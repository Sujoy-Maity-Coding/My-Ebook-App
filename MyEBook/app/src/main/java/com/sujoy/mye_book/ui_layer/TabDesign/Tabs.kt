package com.sujoy.mye_book.ui_layer.TabDesign

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Book
import androidx.compose.material.icons.rounded.Category
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sujoy.mye_book.ui.theme.DarkGreen
import com.sujoy.mye_book.ui.theme.DarkYellow
import com.sujoy.mye_book.ui.theme.LightBlack
import com.sujoy.mye_book.ui.theme.LightGreen
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
fun Tabs(pagerState: PagerState) {
    val coroutineScope= rememberCoroutineScope()
    val tabNames= arrayOf(
        tabItem(Icons.Rounded.Category,"Category"),
        tabItem(Icons.Rounded.Book,"Book")
    )
    TabRow(selectedTabIndex = pagerState.currentPage,
        containerColor = LightGreen,
        indicator = {tabPositions->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                color = Color.White
            )
        },
        modifier = Modifier.clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))) {
        tabNames.forEachIndexed { index, tabItem ->
            Tab(selected = pagerState.currentPage==index,
                modifier = Modifier
                    .height(80.dp),
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Black,
                onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(index)
                }
            }){
                Card(modifier = Modifier.height(60.dp).width(100.dp),
                    colors = CardDefaults.cardColors(containerColor = if (pagerState.currentPage==index) LightGreen else LightBlack)) {
                    Column(modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {
                        Icon(imageVector = tabItem.icon, contentDescription = null,
                            modifier = Modifier.size(25.dp))
                        Text(text = tabItem.title,
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Serif)
                    }
                }
            }
        }
    }
}

data class tabItem(val icon: ImageVector, val title: String)