package com.sujoy.mye_book.ui_layer.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.sujoy.mye_book.ui_layer.MainScreenDesign.BooksByCategory
import com.sujoy.mye_book.ui_layer.TabDesign.TabLayout
import com.sujoy.mye_book.ui_layer.ui_design.showPdfScreen

@Composable
fun NavControllerHost(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationItem.HomeScreen) {
        composable<NavigationItem.HomeScreen> {
            TabLayout(navController = navController)
        }
        composable<NavigationItem.CategoryScreen> {
            val data = it.toRoute<NavigationItem.CategoryScreen>()
            BooksByCategory(navController = navController, category = data.category)
        }
        composable<NavigationItem.ShowPdfScreen> {
            val data = it.toRoute<NavigationItem.ShowPdfScreen>()
            showPdfScreen(url = data.url)
        }
    }
}