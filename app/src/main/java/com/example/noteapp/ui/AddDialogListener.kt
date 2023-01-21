package com.example.noteapp.ui

import com.example.noteapp.data.db.ActionItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ActionItem)
}