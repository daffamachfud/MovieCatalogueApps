package com.onoh.moviecataloguearcapps.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.onoh.moviecataloguearcapps.data.local.entity.MovieEntity
import com.onoh.moviecataloguearcapps.data.local.entity.TvShowEntity

@Database(entities = [MovieEntity::class,TvShowEntity::class],version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao() : AppDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java,
                    "App.db").build()
            }
    }


}