package com.sujoy.mye_book.ui_layer.TabDesign

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.sujoy.mye_book.ui_layer.MainScreenDesign.AllBookScreen
import com.sujoy.mye_book.ui_layer.MainScreenDesign.CategoryScreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabsContent(pagerState: PagerState, navController: NavHostController) {
    HorizontalPager(state = pagerState) {
        when(it){
            0->{
                CategoryScreen(navController=navController)
            }
            1->{
                AllBookScreen(navController=navController)
            }
        }
    }
}
