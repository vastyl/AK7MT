package com.example.noteapp.ui

import android.app.Application
import com.example.noteapp.data.db.ActionDatabase
import com.example.noteapp.repositories.ActionRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class NoteAppApplication:  Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@NoteAppApplication))
        bind() from singleton { ActionDatabase(instance()) }
        bind() from singleton {
            ActionRepository(
                instance()
            )
        }
        bind() from provider {
            ActionItemViewModelFactory(
                instance()
            )
        }
    }
}