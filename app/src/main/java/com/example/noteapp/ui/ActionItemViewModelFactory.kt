package com.example.noteapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.repositories.ActionRepository

class ActionItemViewModelFactory(
    private val repository : ActionRepository
)  : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ActionItemViewModel(repository) as T
    }
}