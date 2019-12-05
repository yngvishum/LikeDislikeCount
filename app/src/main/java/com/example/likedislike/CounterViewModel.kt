package com.example.likedislike

import android.util.Log
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    var likeCount: Int = 0
    var dislikeCount : Int = 0


    init {
        Log.d("ViewModel", "ViewModel created")
    }

    fun incrementLike(){
        likeCount++
    }

    fun incrementDislike(){
        dislikeCount++
    }

    override fun onCleared() {
        Log.d("ViewModel", "ViewModel destroyed")
        super.onCleared()
    }

}