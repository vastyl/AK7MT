package com.example.noteapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ActionItem::class],
    version = 1
)
abstract class ActionDatabase: RoomDatabase() {

    abstract fun getActionDao(): ActionDao

    companion object {
        @Volatile
        private var instance: ActionDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                instance
                    ?: createDatabase(
                        context
                    ).also { instance = it }
            }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ActionDatabase::class.java, "ActionItemDB.db").allowMainThreadQueries().build()
    }
}
