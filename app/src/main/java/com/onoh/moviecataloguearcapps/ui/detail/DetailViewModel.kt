package com.onoh.moviecataloguearcapps.ui.detail

import androidx.lifecycle.ViewModel
import com.onoh.moviecataloguearcapps.data.local.MovieEntity
import com.onoh.moviecataloguearcapps.data.local.TvShowEntity
import com.onoh.moviecataloguearcapps.utils.DataDummy

class DetailViewModel :ViewModel(){
    private var movieId:Int?=0
     private var tvShowId:Int?=0

    fun setSelectedMovie(movieId :Int){
        this.movieId = movieId
    }
    fun setSelectedtvShow(tvShowId :Int){
        this.tvShowId = tvShowId
    }

    fun getMovie(): MovieEntity {
        lateinit var movie: MovieEntity
        val movieEntities = DataDummy.generateDummyMovies()
        for (movieEntity in movieEntities){
            if(movieEntity.movieId == movieId){
                movie = movieEntity
            }
        }
        return movie
    }

    fun getTvShow(): TvShowEntity {
        lateinit var tvShow: TvShowEntity
        val tvShowEntities = DataDummy.generateDummyTvShows()
        for (tvShowEntity in tvShowEntities){
            if(tvShowEntity.tvShowId == tvShowId){
                tvShow = tvShowEntity
            }
        }
        return tvShow
    }
}