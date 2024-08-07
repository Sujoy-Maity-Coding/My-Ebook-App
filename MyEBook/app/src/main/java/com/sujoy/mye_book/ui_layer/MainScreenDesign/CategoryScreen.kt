package com.sujoy.mye_book.ui_layer.MainScreenDesign

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LibraryBooks
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sujoy.mye_book.ui_layer.ViewModel
import com.sujoy.mye_book.ui_layer.ui_design.EachCardCategory
import com.sujoy.mye_book.ui_layer.ui_design.LoadingScreen

@Preview(showSystemUi = true)
@Composable
fun CategoryScreen(
    viewModel: ViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController()
) {
    LaunchedEffect(key1 = true) {
        viewModel.loadCategory()
    }
    val res = viewModel.state.value
    when {
        res.isLoading -> {
            Column(modifier = Modifier.fillMaxSize()) {
                LoadingScreen()
            }
        }

        res.error!!.isNotEmpty() -> {

            Text(text = res.error)
        }

        res.category.isNotEmpty() -> {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                val bookCategory = res.category
                LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
                    items(bookCategory) {
                        EachCardCategory(
                            Category = it.Name,
                            navController = navController,
                            imageUrl = it.categoryImgUrl,
                        )
                    }
                }
            }
        }

        else -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Rounded.LibraryBooks, contentDescription = null,
                        modifier = Modifier.size(150.dp),
                        tint = Color.LightGray
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "No books available",
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Serif
                    )
                }
            }
        }
    }
}
