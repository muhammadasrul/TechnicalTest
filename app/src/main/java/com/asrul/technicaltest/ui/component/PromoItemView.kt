package com.asrul.technicaltest.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import com.asrul.technicaltest.domain.model.Promo
import com.asrul.technicaltest.ui.component.assets.DefaultImage

@Composable
fun PromoItemView(
    promo: Promo,
    onClicked: (Promo) -> Unit
) {
    var imageErr by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.clickable { onClicked(promo) }
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
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Preview
@Composable
fun PromoItemViewPreview() {
    PromoItemView(promo = Promo(desc = "mediocritatem", img = "platonem", nama = "rhoncus")) {

    }
}