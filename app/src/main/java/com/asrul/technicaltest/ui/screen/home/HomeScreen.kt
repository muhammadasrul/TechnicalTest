package com.asrul.technicaltest.ui.screen.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asrul.technicaltest.domain.model.User
import com.asrul.technicaltest.ui.component.ErrorView
import com.asrul.technicaltest.ui.component.MenuIcon
import com.asrul.technicaltest.ui.component.PrimaryButton
import com.asrul.technicaltest.ui.component.TransactionItemView
import com.asrul.technicaltest.ui.component.TransactionSkeleton
import com.asrul.technicaltest.ui.component.assets.DiscountIcon
import com.asrul.technicaltest.ui.component.assets.QuestionIcon
import com.asrul.technicaltest.ui.theme.AppBlueDark
import com.asrul.technicaltest.ui.theme.AppYellow

@Composable
internal fun HomeScreen(
    transactionState: TransactionHistoryState,
    userState: UserState,
    goToHistory: () -> Unit,
    goToQrScanner: () -> Unit,
    goToPromo: () -> Unit
) {
    Scaffold { paddingValues ->
        Surface {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
            ) {
                LazyColumn(
                    Modifier.weight(1f)
                ) {
                    item {
                        HomeCard(
                            name = userState.data?.name ?: "-",
                            currentBalance = userState.data?.currentBalance ?: 0.0,
                            usedInAMonth = transactionState.usedInMonth
                        )
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            MenuIcon(
                                color = AppYellow,
                                name = "Promo",
                                iconVector = DiscountIcon,
                                onClicked = goToPromo
                            )
                            MenuIcon(
                                color = AppBlueDark,
                                name = "Dummy",
                                iconVector = QuestionIcon,
                                onClicked = {}
                            )
                            MenuIcon(
                                color = AppBlueDark,
                                name = "Dummy",
                                iconVector = QuestionIcon,
                                onClicked = {}
                            )
                            MenuIcon(
                                color = AppBlueDark,
                                name = "Dummy",
                                iconVector = QuestionIcon,
                                onClicked = {}
                            )
                        }
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .fillMaxWidth()
                                .background(AppBlueDark.copy(.05f))
                                .padding(horizontal = 18.dp, vertical = 6.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier.padding(start = 8.dp),
                                text = "Recent Transaction",
                                style = MaterialTheme.typography.headlineSmall,
                                color = Black
                            )
                            TextButton(
                                onClick = goToHistory,
                                colors = ButtonDefaults.buttonColors(AppBlueDark)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        modifier = Modifier.padding(top = 3.dp, start = 4.dp),
                                        text = "See All",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = White
                                    )
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowRight,
                                        contentDescription = "All Transaction"
                                    )
                                }
                            }
                        }
                    }
                    item {
                        if (transactionState.isLoading) {
                            TransactionSkeleton()
                        }
                    }
                    item {
                        AnimatedVisibility(visible = !transactionState.isLoading && transactionState.error.isNotEmpty()) {
                            ErrorView(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(400.dp),
                                title = if (transactionState.data.isEmpty()) "No Transaction" else "Oops, Sorry",
                                message = transactionState.error,
                                textColor = Black,
                            )
                        }
                    }
                    if (!transactionState.isLoading && transactionState.error.isEmpty()) {
                        transactionState.data.forEach {
                            item {
                                Text(
                                    modifier = Modifier.padding(
                                        top = 20.dp,
                                        bottom = 8.dp,
                                        start = 24.dp,
                                        end = 24.dp
                                    ),
                                    text = it.key,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = Black
                                )
                            }
                            itemsIndexed(items = it.value) { index, item ->
                                TransactionItemView(
                                    modifier = Modifier.padding(horizontal = 14.dp),
                                    transaction = item,
                                    isLastItem = index == it.value.lastIndex
                                )
                            }
                        }
                    }
                }

                PrimaryButton(
                    modifier = Modifier
                        .padding(vertical = 24.dp, horizontal = 18.dp)
                        .fillMaxWidth(),
                    text = "QR Scanner", action = goToQrScanner
                )
            }
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        transactionState = TransactionHistoryState(error = "Error"),
        userState = UserState(
            data = User(
                id = "morbi",
                currentBalance = 2.3,
                name = "Bertha Espinoza"
            )
        ),
        goToHistory = {},
        goToQrScanner = {},
        goToPromo = {}
    )
}