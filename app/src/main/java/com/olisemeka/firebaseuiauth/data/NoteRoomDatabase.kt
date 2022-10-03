package com.olisemeka.firebaseuiauth.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteRoomDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        private var noteRoomInstance: NoteRoomDatabase? = null

        fun getDatabase(context: Context): NoteRoomDatabase {
            return noteRoomInstance?: synchronized(this){
                val instance = Room.databaseBuilder<NoteRoomDatabase>(
                            context.applicationContext,
                            NoteRoomDatabase::class.java,
                            "note_database"
                        )
                            .build()
                noteRoomInstance = instance
                instance
            }
//            if (noteRoomInstance == null) {
//                synchronized(NoteRoomDatabase::class.java) {
//                    if (noteRoomInstance == null)
//                        noteRoomInstance = Room.databaseBuilder<NoteRoomDatabase>(
//                            context.applicationContext,
//                            NoteRoomDatabase::class.java,
//                            "note_database"
//                        )
//                            .build()
//                }
//            }
//
//            return noteRoomInstance
        }
    }
}