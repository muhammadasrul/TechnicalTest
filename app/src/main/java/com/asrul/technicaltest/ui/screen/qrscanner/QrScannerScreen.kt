package com.asrul.technicaltest.ui.screen.qrscanner

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS
import android.util.Size
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.asrul.technicaltest.data.local.entity.TransactionEntity
import com.asrul.technicaltest.ui.component.ErrorView
import com.asrul.technicaltest.util.QrCodeAnalyzer
import com.asrul.technicaltest.util.toQrResultDTO
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun QrScannerScreen(
    onCloseClicked: () -> Unit,
    transactionState: InsertTransactionState,
    onQrScanned: (TransactionEntity) -> Unit,
    onHandled: () -> Unit
) {
    val ctx = LocalContext.current
    val cameraProvider = remember { ProcessCameraProvider.getInstance(ctx) }
    val lifecycleOwner = LocalLifecycleOwner.current
    var hasPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                ctx,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
    }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted -> hasPermission = granted }
    )
    var isError by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        launcher.launch(Manifest.permission.CAMERA)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "QRIS",
                        style = MaterialTheme.typography.headlineMedium,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onCloseClicked) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Close",
                            tint = Gray
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            if (hasPermission) {
                AndroidView(
                    modifier = Modifier
                        .weight(1f)
                        .padding(18.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    factory = { context ->
                        val previewView = PreviewView(context)
                        val preview = androidx.camera.core.Preview.Builder().build()
                        val selector = CameraSelector.Builder()
                            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                            .build()
                        preview.setSurfaceProvider(previewView.surfaceProvider)
                        val imageAnalysis = ImageAnalysis.Builder()
                            .setTargetResolution(Size(previewView.height, previewView.width))
                            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                            .build()
                        imageAnalysis.setAnalyzer(
                            ContextCompat.getMainExecutor(context),
                            QrCodeAnalyzer { qrResult ->
                                val resultDto = qrResult.toQrResultDTO()

                                if (resultDto != null) {
                                    val timeStamp = Calendar.getInstance().timeInMillis
                                    val transaction = TransactionEntity(
                                        transactionId = resultDto.transactionId,
                                        merchant = resultDto.merchant,
                                        transactionAmount = resultDto.transactionAmount.toDouble(),
                                        date = timeStamp
                                    )
                                    onQrScanned(transaction)
                                } else {
                                    isError = true
                                }
                            })

                        try {
                            cameraProvider.get().bindToLifecycle(
                                lifecycleOwner,
                                selector,
                                preview,
                                imageAnalysis
                            )
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                        previewView
                    }
                )
            } else {
                ErrorView(
                    modifier = Modifier
                        .weight(1f)
                        .padding(18.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Black)
                        .padding(18.dp),
                    title = "Akses ke kamera belum aktif",
                    textColor = White,
                    message = "Yuk, akses ke kemara diaktifkan dulu biar bisa mulai bayar dengan ngescan kode QR.",
                    actionText = "Ke Pengaturan"
                ) {
                    ctx.startActivity(
                        Intent(ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                            data = Uri.fromParts("package", ctx.packageName, null)
                        }
                    )
                }
            }
            if (isError || transactionState.error.isNotEmpty()) {
                ErrorView(
                    modifier = Modifier
                        .weight(1f)
                        .padding(18.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Black)
                        .padding(18.dp),
                    title = "Oops",
                    textColor = White,
                    message = transactionState.error.ifEmpty { "Kode QR tidak valid." },
                    actionText = "Ok"
                ) {
                    isError = false
                    onHandled()
                }
            }
            Text(
                modifier = Modifier
                    .padding(top = 18.dp, bottom = 42.dp)
                    .fillMaxWidth(),
                text = "Scan kode QR untuk bayar",
                style = MaterialTheme.typography.labelLarge,
                color = Black,
                textAlign = TextAlign.Center
            )
        }
    }
}