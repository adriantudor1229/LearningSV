package com.example.learning.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class SimpleViewModel : ViewModel() {

    private val _name = MutableLiveData("Ada")
    private val _lastName = MutableLiveData("Lovelace")
    private val _likes = MutableLiveData(0)

    val name : LiveData<String> = _name
    val lastName : LiveData<String> = _lastName
    val likes : LiveData<Int> = _likes


    val popularity  : LiveData<Popularity> = _likes.map{
        when{
            it > 9 -> Popularity.STAR
            it > 4 -> Popularity.POPULAR
            else -> Popularity.NORMAL
        }
    }
    fun onLike(){
        _likes.value = (_likes.value ?: 0) + 1
    }
}


enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}