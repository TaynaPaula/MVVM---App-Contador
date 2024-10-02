package com.example.contador.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Maingui_viewModel : ViewModel() {
    private val _contador = MutableLiveData<Int>(0)
    var contador =_contador

    fun incrementaContador(){
        _contador.value = _contador.value?.plus(1)
    }

}