package com.onoh.moviecataloguearcapps.data

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.onoh.moviecataloguearcapps.data.local.MovieEntity
import com.onoh.moviecataloguearcapps.data.local.TvShowEntity

interface AppDataSource {
    fun getAllMovies(apiKey:String): LiveData<List<MovieEntity>>

    fun getDetailMovie(movieId:Int):LiveData<MovieEntity>

    fun getAllTvshows(apiKey:String): LiveData<List<TvShowEntity>>

    fun getDetailTvshow(tvShowId:Int): LiveData<TvShowEntity>
}