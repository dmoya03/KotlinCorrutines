package com.example.kotlincorrutinesmvvm.ViewModel

// MainViewModel.kt
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincorrutinesmvvm.Model.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {
    constructor() : this(Repository())

    fun fetchData(completion: (String) -> Unit) {
        viewModelScope.launch {
            val result = repository.fetchData().data
            completion(result)
        }
    }
}
