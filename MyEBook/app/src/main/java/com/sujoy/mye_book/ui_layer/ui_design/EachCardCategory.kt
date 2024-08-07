package com.sujoy.mye_book.ui_layer.ui_design

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.SubcomposeAsyncImage
import com.sujoy.mye_book.ui.theme.LightBlack
import com.sujoy.mye_book.ui_layer.Navigation.NavigationItem

@Composable
fun EachCardCategory(Category: String, navController: NavHostController, imageUrl: String) {
    Card(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)
        .height(180.dp)
        .clip(RoundedCornerShape(8.dp))
        .clickable { navController.navigate(NavigationItem.CategoryScreen(category = Category)) },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)) {
        SubcomposeAsyncImage(
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(8.dp)),
            loading = {
                LoadingScreen()
            },
            error = {
                Text(text = "Error loading image")
            }
        )
        Box(
            modifier = Modifier.fillMaxWidth().padding(end = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = Category,
                color = LightBlack,
                fontWeight = FontWeight.Bold)
        }
    }

}