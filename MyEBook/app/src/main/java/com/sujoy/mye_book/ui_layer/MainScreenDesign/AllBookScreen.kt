package com.sujoy.mye_book.ui_layer.MainScreenDesign

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sujoy.mye_book.ui_layer.ViewModel
import com.sujoy.mye_book.ui_layer.ui_design.EachCardBook
import com.sujoy.mye_book.ui_layer.ui_design.NoBookScreen

@Composable
fun AllBookScreen(
    modifier: Modifier = Modifier,
    viewModel: ViewModel = hiltViewModel(),
    navController: NavHostController
) {
    LaunchedEffect(key1 = true) {
        viewModel.LoadBooks()
    }
    val res = viewModel.state.value

    when {
        res.isLoading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

        res.error!!.isNotEmpty() -> {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(text = res.error)
            }
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
            NoBookScreen()
        }
    }
}