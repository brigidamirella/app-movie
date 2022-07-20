package com.example.themovie.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.themovie.data.TheMoviesDao
import com.example.themovie.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun dao(): TheMoviesDao

    companion object {
        private lateinit var INSTANCE: AppDataBase
        fun getDataBase(context: Context): AppDataBase {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java, "moviedb"
                ).allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}