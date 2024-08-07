package com.sujoy.mye_book.ui_layer.MainScreenDesign

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sujoy.mye_book.ui_layer.ViewModel
import com.sujoy.mye_book.ui_layer.ui_design.EachCardBook
import com.sujoy.mye_book.ui_layer.ui_design.LoadingScreen
import com.sujoy.mye_book.ui_layer.ui_design.NoBookScreen

@Composable
fun BooksByCategory(
    category: String,
    viewModel: ViewModel = hiltViewModel(),
    navController: NavHostController
) {
    LaunchedEffect(Unit) {
        viewModel.LoadBooksByCategory(category = category)
    }
    val res = viewModel.state.value
    when {
        res.isLoading -> {
            LoadingScreen()
        }

        res.error!!.isNotEmpty() -> {
            Text(text = res.error)
        }

        res.items.isNotEmpty() -> {
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(res.items) {
                        EachCardBook(
                            imageUrl = it.bookImage,
                            title = it.bookName,
                            author = it.bookAuthor,
                            description = it.bookDescription,
                            navController = navController,
                            bookUrl = it.bookUrl
                        )
                    }
                }
            }
        }

        else -> {
            NoBookScreen(navController = navController)
        }
    }
}
