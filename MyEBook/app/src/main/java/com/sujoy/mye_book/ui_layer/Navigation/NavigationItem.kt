package com.sujoy.mye_book.ui_layer.Navigation

import kotlinx.serialization.Serializable

sealed class NavigationItem {
    @Serializable
    object HomeScreen

    @Serializable
    data class CategoryScreen(val category: String)

    @Serializable
    data class ShowPdfScreen(val url: String)

}