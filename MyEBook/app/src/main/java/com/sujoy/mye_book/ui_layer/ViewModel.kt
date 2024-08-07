package com.sujoy.mye_book.ui_layer

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sujoy.mye_book.Common.BookCategoryModel
import com.sujoy.mye_book.Common.BookModel
import com.sujoy.mye_book.Common.ResultState
import com.sujoy.mye_book.domain_layer.Repo.AllBookRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(val repo: AllBookRepo): ViewModel(){
    private val _state: MutableState<ItemsState> = mutableStateOf(ItemsState())
    val state: MutableState<ItemsState> = _state

    fun loadCategory() {
        viewModelScope.launch {
            repo.getAllBookCategory().collect{
                when(it){
                    is ResultState.Error -> {
                        _state.value = ItemsState(error = it.exception.localizedMessage)
                    }
                    ResultState.Loading -> {
                        _state.value = ItemsState(isLoading = true)
                    }
                    is ResultState.Success -> {
                        _state.value = ItemsState(category = it.data)
                    }
                }
            }
        }
    }

    fun LoadBooks(){
        viewModelScope.launch {
            repo.getAllBook().collect{
                when(it){
                    is ResultState.Error -> {
                        _state.value = ItemsState(error = it.exception.localizedMessage)
                    }
                    ResultState.Loading -> {
                        _state.value = ItemsState(isLoading = true)
                    }
                    is ResultState.Success -> {
                        _state.value = ItemsState(items = it.data)
                    }
                }
            }
        }
    }

    fun LoadBooksByCategory(category: String){
        viewModelScope.launch {
            repo.getAllBookByCategory(category).collect{
                when(it){
                    is ResultState.Error -> {
                        _state.value = ItemsState(error = it.exception.localizedMessage)
                    }
                    ResultState.Loading -> {
                        _state.value = ItemsState(isLoading = true)
                    }
                    is ResultState.Success -> {
                        _state.value = ItemsState(items = it.data)
                    }
                }
            }
        }
    }
}

data class ItemsState(
    val items: List<BookModel> = emptyList(),
    val category: List<BookCategoryModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = ""
)