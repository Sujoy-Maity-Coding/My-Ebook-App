package com.sujoy.mye_book.ui_layer.TabDesign

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayout(padding: PaddingValues = PaddingValues(0.dp), navController: NavHostController) {
    val pagerState = rememberPagerState(pageCount = {2})
    Column(modifier = Modifier.padding(padding)) {
        Tabs(pagerState = pagerState)
        TabsContent(pagerState = pagerState,navController=navController)
    }
}