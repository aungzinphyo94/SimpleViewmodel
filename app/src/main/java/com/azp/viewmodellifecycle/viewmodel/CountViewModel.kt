package com.azp.viewmodellifecycle.viewmodel

import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel(){
    private var count : Int = 1

    fun getCount(): Int = count

    fun setCount(): Int {
        count++
        return count
    }
}