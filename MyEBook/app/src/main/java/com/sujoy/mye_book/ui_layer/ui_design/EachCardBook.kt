package com.sujoy.mye_book.ui_layer.ui_design

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.SubcomposeAsyncImage
import com.sujoy.mye_book.ui.theme.LightBlack
import com.sujoy.mye_book.ui.theme.LightGreen
import com.sujoy.mye_book.ui_layer.Navigation.NavigationItem

@Composable
fun EachCardBook(
    imageUrl: String,
    title: String,
    author: String,
    description: String,
    navController: NavHostController,
    bookUrl: String
) {

    Card(modifier = Modifier
        .fillMaxSize()
        .clip(RoundedCornerShape(8.dp))
        .padding(15.dp)
        .clickable { navController.navigate(NavigationItem.ShowPdfScreen(url = bookUrl)) },
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Row {
            SubcomposeAsyncImage(
                model = imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .padding(10.dp)
                    .align(Alignment.CenterVertically)
                    .clip(RoundedCornerShape(8.dp)),
                loading = {
                    LoadingScreen()
                },
                error = {
                    Text(text = "Error loading image")
                }
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Serif)
                Text(text = description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif)
                Text(text = "—$author",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp)
                        .align(Alignment.End),
                    color = LightBlack,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.Cursive)
            }
        }
    }
}