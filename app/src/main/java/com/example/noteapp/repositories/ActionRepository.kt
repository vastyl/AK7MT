package com.example.noteapp.repositories

import com.example.noteapp.data.db.ActionDatabase
import com.example.noteapp.data.db.ActionItem

class ActionRepository(
    private val db: ActionDatabase
) {
    fun upsert(item: ActionItem) = db.getActionDao().upsert(item)
//suspend
    fun delete(item: ActionItem) = db.getActionDao().delete(item)

    fun getAllActionItems() = db.getActionDao().getAllActionItems()
}