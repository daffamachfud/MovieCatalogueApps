package com.onoh.moviecataloguearcapps.data

import androidx.lifecycle.LiveData
import com.onoh.moviecataloguearcapps.data.local.entity.MovieEntity
import com.onoh.moviecataloguearcapps.data.local.entity.TvShowEntity
import com.onoh.moviecataloguearcapps.vo.Resource

interface AppDataSource {
    fun getAllMovies(): LiveData<Resource<List<MovieEntity>>>

    fun getDetailMovie(movieId:Int):LiveData<Resource<MovieEntity>>

    fun getAllTvshows(): LiveData<Resource<List<TvShowEntity>>>

    fun getDetailTvshow(tvShowId:Int): LiveData<Resource<TvShowEntity>>

    fun setFavoriteMovie(movie:MovieEntity,state:Boolean)

    fun setFavoriteTvShow(tvShow:TvShowEntity,state: Boolean)
}