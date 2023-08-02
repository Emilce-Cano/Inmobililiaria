package com.example.concesionaria

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class productFactory(private var myRepo : Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductViewModel(this, myRepo) as T
    }
}