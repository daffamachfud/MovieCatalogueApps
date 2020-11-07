package com.onoh.moviecataloguearcapps.di

import android.content.Context
import com.onoh.moviecataloguearcapps.data.AppRepository
import com.onoh.moviecataloguearcapps.data.local.LocalDataSource
import com.onoh.moviecataloguearcapps.data.local.room.AppDatabase
import com.onoh.moviecataloguearcapps.data.remote.RemoteDataSource
import com.onoh.moviecataloguearcapps.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): AppRepository {

        val database = AppDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.appDao())
        val appExecutors = AppExecutors()

        return AppRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}