package com.asrul.technicaltest.ui.screen.promo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.asrul.technicaltest.domain.model.Promo
import com.asrul.technicaltest.ui.component.ErrorView
import com.asrul.technicaltest.ui.component.PromoItemView
import com.asrul.technicaltest.ui.component.TransactionSkeleton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PromoListScreen(
    state: PromoState,
    onBackPressed: () -> Unit,
    onClicked: (Promo) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Promo List",
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
                LazyColumn {
                    item {
                        if (state.isLoading) {
                            TransactionSkeleton(4)
                        }
                    }
                    item {
                        AnimatedVisibility(visible = !state.isLoading && state.error.isNotEmpty()) {
                            ErrorView(
                                modifier = Modifier
                                    .height(600.dp)
                                    .fillMaxSize(),
                                title = if (state.data.isEmpty()) "Currently, no promotions available. Stay tuned for future offers!" else "Oops, Sorry",
                                message = state.error,
                                textColor = Color.Black
                            )
                        }
                    }
                    if (!state.isLoading && state.error.isEmpty()) {
                        items(items = state.data) { item ->
                            PromoItemView(promo = item, onClicked = { onClicked(it) })
                        }
                    }
                }
            }
        }
    }
}