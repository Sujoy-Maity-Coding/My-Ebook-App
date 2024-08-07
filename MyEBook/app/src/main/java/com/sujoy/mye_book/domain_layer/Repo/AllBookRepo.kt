package com.sujoy.mye_book.domain_layer.Repo

import com.sujoy.mye_book.Common.BookCategoryModel
import com.sujoy.mye_book.Common.BookModel
import com.sujoy.mye_book.Common.ResultState
import kotlinx.coroutines.flow.Flow

interface AllBookRepo {
    fun getAllBook(): Flow<ResultState<List<BookModel>>>
    fun getAllBookCategory(): Flow<ResultState<List<BookCategoryModel>>>
    fun getAllBookByCategory(category: String): Flow<ResultState<List<BookModel>>>
}