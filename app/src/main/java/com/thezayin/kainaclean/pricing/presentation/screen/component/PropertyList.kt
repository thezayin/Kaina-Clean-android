package com.thezayin.kainaclean.pricing.presentation.screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.pricing.domain.model.PropertyType
import com.thezayin.kainaclean.pricing.presentation.viewmodel.PricingViewModel


@Composable
fun PropertyList(
    propertyType: PropertyType,
    modifier: Modifier,
    onItemClick: (PropertyType) -> Unit,
) {

    val viewModel: PricingViewModel = hiltViewModel()
    Card(
        modifier = modifier
            .width(150.dp)
            .clickable {
                viewModel.selectedProperty = propertyType.name!!
                onItemClick(
                    propertyType.copy(
                        isSelected = propertyType.isSelected?.not()
                    )
                )
            },
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)

        ) {
            Text(
                text = propertyType.name!!,
                textAlign = TextAlign.Center,
                color = colorResource(id = if (propertyType.isSelected == true) R.color.btn_primary else R.color.grey),
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp)
                    .background(color = colorResource(id = if (propertyType.isSelected == true) R.color.btn_primary else R.color.grey))
                    .height(1.dp)
            )
        }
    }
}