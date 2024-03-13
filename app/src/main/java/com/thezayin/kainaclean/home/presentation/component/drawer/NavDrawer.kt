package com.thezayin.kainaclean.home.presentation.component.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.home.domain.model.DrawerItem
import kotlinx.coroutines.launch

@Preview
@Composable
fun NavDrawer() {
    val drawerItem = listOf(DrawerItem(R.drawable.ic_quote, "My Quotes"))

    var selectedItem by remember {
        mutableStateOf(drawerItem[0])
    }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(drawerContent = {
        ModalDrawerSheet {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(color = colorResource(id = R.color.background))
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Text(
                        text = "Kaina Cleans",
                        fontWeight = FontWeight.ExtraBold,
                        color = colorResource(id = R.color.text_color),
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                    )
                }
            }
            drawerItem.forEach {
                NavigationDrawerItem(label = { Text(text = it.title) },
                    modifier = Modifier.padding(horizontal = 20.dp),
                    selected = it == selectedItem,
                    onClick = {
                        selectedItem = it

                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon = {
                        Icon(painter = painterResource(id = it.icon), contentDescription = it.title)
                    }
                )
            }
        }
    }) {

    }
}