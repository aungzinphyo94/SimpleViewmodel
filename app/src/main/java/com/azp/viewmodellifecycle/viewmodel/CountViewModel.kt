package com.azp.viewmodellifecycle.viewmodel

import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {
    private var count: Int = 0 //2  //variable

    fun getCount(): Int = count    //getter

    fun setCount(num: Int): Int {           //setter
        count = num
        count++
        return count
    }
}