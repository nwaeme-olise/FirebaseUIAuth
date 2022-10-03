package com.olisemeka.firebaseuiauth.data

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NoteViewModel(private val db: NoteRoomDatabase) : ViewModel() {
    val allNotes: LiveData<List<Note>>
    private val noteDao = db.noteDao()

    init {
        allNotes = noteDao.allNotes
    }

    fun insert(note: Note) {
        InsertAsyncTask(noteDao).execute(note)
    }

    companion object {
        private class InsertAsyncTask(private val noteDao: NoteDao) : AsyncTask<Note, Void, Void>() {
            override fun doInBackground(vararg notes: Note): Void? {
                noteDao.insert(notes[0])
                return null
            }

        }
    }
}

class NoteViewModelFactory(private val db: NoteRoomDatabase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NoteViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}