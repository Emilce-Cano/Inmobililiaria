package com.example.concesionaria

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProductFactory(private var serviceImp: ServiceImp) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductViewModel(serviceImp) as T
    }
}
