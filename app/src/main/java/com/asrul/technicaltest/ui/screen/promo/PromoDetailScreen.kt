package com.asrul.technicaltest.ui.screen.promo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import com.asrul.technicaltest.domain.model.Promo
import com.asrul.technicaltest.ui.component.assets.DefaultImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PromoDetailScreen(
    promo: Promo,
    onBackPressed: () -> Unit
) {
    var imageErr by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Detail Promo",
                        style = MaterialTheme.typography.headlineMedium,
                    )
                },
                navigationIcon = {
                    IconButton(onBackPressed) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Close",
                            tint = Color.Black
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Surface {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth,
                    model = promo.img,
                    contentDescription = "promo",
                    onState = {
                        imageErr = it is AsyncImagePainter.State.Error
                    }
                )
                if (imageErr) {
                    Image(
                        modifier = Modifier
                            .padding(vertical = 18.dp)
                            .fillMaxWidth(),
                        imageVector = DefaultImage,
                        contentDescription = "error"
                    )
                }

                Text(
                    modifier = Modifier.padding(18.dp),
                    text = promo.nama,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    modifier = Modifier.padding(horizontal = 18.dp),
                    text = promo.desc,
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview
@Composable
fun PromoDetailScreenPreview() {
    PromoDetailScreen(promo = Promo(desc = "verear", img = "et", nama = "porta")) {}
}