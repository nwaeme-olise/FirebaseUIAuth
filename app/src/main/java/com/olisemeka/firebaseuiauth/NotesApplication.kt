package com.olisemeka.firebaseuiauth

import android.app.Application
import com.olisemeka.firebaseuiauth.data.NoteRoomDatabase

class NotesApplication: Application() {
    val database by lazy { NoteRoomDatabase.getDatabase(this) }
}