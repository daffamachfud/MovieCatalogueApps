package com.onoh.moviecataloguearcapps.data

import androidx.lifecycle.LiveData
import com.onoh.moviecataloguearcapps.data.local.MovieEntity
import com.onoh.moviecataloguearcapps.data.local.TvShowEntity

interface AppDataSource {
    fun getAllMovies(): LiveData<List<MovieEntity>>

    fun getDetailMovie(movieId:Int):LiveData<MovieEntity>

    fun getAllTvshows(): LiveData<List<TvShowEntity>>

    fun getDetailTvshow(tvShowId:Int): LiveData<TvShowEntity>
}