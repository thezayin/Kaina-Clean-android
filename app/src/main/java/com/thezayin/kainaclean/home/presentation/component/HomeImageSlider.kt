package com.thezayin.kainaclean.home.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.home.presentation.component.slider.carousel.AutoSlidingCarousel

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeImageSlider(modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp),
    ) {
        val images = listOf(
            painterResource(id = R.drawable.ic_slide_first),
            painterResource(id = R.drawable.ic_slide_sec),
            painterResource(id = R.drawable.ic_slider_third),
        )
        Card(
            shape = RoundedCornerShape(16.dp),
        ) {
            AutoSlidingCarousel(
                itemsCount = images.size,
                itemContent = { index ->
                    Image(
                        painter = images[index],
                        contentDescription = "Carousel Images",
                        contentScale = ContentScale.Crop
                    )
                })
        }
    }
}