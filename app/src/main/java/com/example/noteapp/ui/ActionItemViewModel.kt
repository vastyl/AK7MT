package com.example.noteapp.ui

import androidx.lifecycle.ViewModel
import com.example.noteapp.data.db.ActionItem
import com.example.noteapp.repositories.ActionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActionItemViewModel(
    private val repository : ActionRepository
) : ViewModel(){
    fun upsert(item: ActionItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ActionItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllActionItems() =repository.getAllActionItems()
}