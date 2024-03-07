package com.thezayin.kainaclean.presentation.myquote

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.presentation.myquote.component.QuoteCard
import com.thezayin.kainaclean.util.Response

@Destination
@Composable
fun MyQuotes(
    navigator: DestinationsNavigator
) {
    val quoteViewModel: MyQuotesViewModel = hiltViewModel()
    val quoteUiState = quoteViewModel.detailUiState ?: MyQuotesViewModel.QuoteUiState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(color = colorResource(id = R.color.background))
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "",
                    modifier = Modifier
                        .size(22.dp).fillMaxHeight().align(Alignment.CenterStart)
                        .clickable {
                            navigator.navigateUp()
                        })
                Text(
                    text = "Request a Quote",
                    fontSize = 24.sp,
                    color = colorResource(id = R.color.text_color),
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily(Font(R.font.nunito_extrabold)),
                    modifier = Modifier
                        .align(alignment = Alignment.Center)

                )
            }

                Column(modifier = Modifier
                    .padding(10.dp)
                    .background(color = colorResource(id = R.color.background))) {
                    when (quoteUiState.quoteList) {
                        is Response.Loading -> {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .wrapContentSize(align = Alignment.Center)
                            )
                        }

                        is Response.Success -> {
                            LazyVerticalGrid(columns = GridCells.Fixed(1)) {
                                items(quoteUiState.quoteList.data.sortedBy { it.date }
                                    ?: emptyList()) { quote ->
                                    QuoteCard(quote = quote)
                                }
                            }
                        }

                        else -> {
                            Text(text = "There is no data")
                        }
                    }
                }
            }
        }
    }



