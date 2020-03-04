package com.udacity.shoestore.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class MainViewModel : ViewModel() {
    //var shoes : MutableList<Shoe> = mutableListOf()
    var shoes : MutableLiveData<MutableList<Shoe>> = MutableLiveData(mutableListOf())

    init {
        Timber.i("ShoeViewModel created!")
    }

    fun newShoe(name : String, size : Double, company : String, description : String) {
        val shoe = Shoe(name, size, company, description)

        //shoes.add(shoe)
        shoes.value?.add(shoe)
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoeViewModel destroyed!")
    }
}