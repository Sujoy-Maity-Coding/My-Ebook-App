package com.sujoy.mye_book.ui_layer.ui_design

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LibraryBooks
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sujoy.mye_book.ui.theme.LightGreen
import com.sujoy.mye_book.ui_layer.Navigation.NavigationItem

@Preview(showSystemUi = true)
@Composable
fun NoBookScreen(navController: NavHostController= rememberNavController()) {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(imageVector = Icons.Rounded.LibraryBooks, contentDescription = null,
                modifier = Modifier.size(150.dp),
                tint = Color.LightGray)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "No books available",
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Serif)
            Spacer(modifier = Modifier.size(20.dp))
            Button(onClick = {
                navController.navigate(NavigationItem.HomeScreen)
            },
                colors = ButtonDefaults.buttonColors(containerColor = LightGreen)) {
                Text(text = "Go Home",
                    fontSize = 15.sp)
            }
        }
    }
}