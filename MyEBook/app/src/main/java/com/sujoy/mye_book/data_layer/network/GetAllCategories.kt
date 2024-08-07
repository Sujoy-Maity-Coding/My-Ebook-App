package com.sujoy.mye_book.data_layer.network

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.sujoy.mye_book.data_layer.models.CategoryDTO
import javax.inject.Inject

class GetAllCategories @Inject constructor(val firebaseDatabase: FirebaseDatabase){
    fun getAllCategory(){
        val categoryListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val category = dataSnapshot.getValue<CategoryDTO>()
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        firebaseDatabase.reference.child("BookCategory")
    }
}