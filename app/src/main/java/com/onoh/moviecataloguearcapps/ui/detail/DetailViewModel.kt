package com.onoh.moviecataloguearcapps.ui.detail

import androidx.lifecycle.ViewModel
import com.onoh.moviecataloguearcapps.data.MovieEntity
import com.onoh.moviecataloguearcapps.data.TvShowEntity
import com.onoh.moviecataloguearcapps.utils.DataDummy

class DetailViewModel :ViewModel(){
    private lateinit var movieId:String
    private lateinit var tvShowId:String

    fun setSelectedMovie(movieId :String){
        this.movieId = movieId
    }
    fun setSelectedtvShow(tvShowId :String){
        this.tvShowId = tvShowId
    }

    fun getMovie():MovieEntity{
        lateinit var movie:MovieEntity
        val movieEntities = DataDummy.generateDummyMovies()
        for (movieEntity in movieEntities){
            if(movieEntity.movieId == movieId){
                movie = movieEntity
            }
        }
        return movie
    }

    fun getTvShow():TvShowEntity{
        lateinit var tvShow:TvShowEntity
        val tvShowEntities = DataDummy.generateDummyTvShows()
        for (tvShowEntity in tvShowEntities){
            if(tvShowEntity.tvShowId == tvShowId){
                tvShow = tvShowEntity
            }
        }
        return tvShow
    }
}