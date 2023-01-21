package com.example.noteapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ActionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(item: ActionItem)

    @Delete
    fun delete(item: ActionItem)

    @Query("SELECT * FROM action_items")
    fun getAllActionItems(): LiveData<List<ActionItem>>

}