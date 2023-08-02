package com.example.concesionaria

import androidx.lifecycle.ViewModel

class ProductViewModel(private var repository: InterfaceRepository) : ViewModel(){
    private var data = MutableLiveData<MutableList<Pro>>

}