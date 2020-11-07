package com.onoh.moviecataloguearcapps.data.local

import androidx.lifecycle.LiveData
import com.onoh.moviecataloguearcapps.data.local.entity.MovieEntity
import com.onoh.moviecataloguearcapps.data.local.entity.TvShowEntity
import com.onoh.moviecataloguearcapps.data.local.room.AppDao

class LocalDataSource private constructor(private val mAppDao:AppDao){

    companion object{
        private var INSTANCE : LocalDataSource? = null

        fun getInstance(appDao: AppDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(appDao)
    }

    fun getAllMovies(): LiveData<List<MovieEntity>> = mAppDao.getAllMovies()

    fun getAllTvShows(): LiveData<List<TvShowEntity>> = mAppDao.getAllTvShows()

    fun getFavoriteMovies() : LiveData<List<MovieEntity>> = mAppDao.getFavoriteMovies()

    fun getFavoriteTvshows() :  LiveData<List<TvShowEntity>> = mAppDao.getFavoriteTvshows()

    fun getLocalDetailMovie(movieId : Int) : LiveData<MovieEntity> = mAppDao.getDetailMovie(movieId)

    fun getLocalDetailTvshow(tvShowId : Int) : LiveData<TvShowEntity> = mAppDao.getDetailTvShow(tvShowId)

    fun insertAllMovies(movies: List<MovieEntity>) = mAppDao.insertMovies(movies)

    fun insertAllTvShow(tvShows: List<TvShowEntity>) = mAppDao.insertTvshows(tvShows)

    fun insertMovies(movie: MovieEntity) = mAppDao.insertDetailMovies(movie)

    fun insertTvShow(tvShow: TvShowEntity) = mAppDao.insertDetailTvshows(tvShow)

    fun setFavoriteMovie(movie:MovieEntity,newState:Boolean){
        movie.favorite = newState
        mAppDao.updateMovie(movie)
    }

    fun setFavoriteTvShow(tvShow:TvShowEntity,newState: Boolean){
        tvShow.favorite = newState
        mAppDao.updateTvShow(tvShow)
    }

}