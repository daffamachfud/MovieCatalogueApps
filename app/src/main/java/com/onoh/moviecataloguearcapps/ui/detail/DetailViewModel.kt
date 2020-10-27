package com.onoh.moviecataloguearcapps.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onoh.moviecataloguearcapps.data.AppRepository
import com.onoh.moviecataloguearcapps.data.local.MovieEntity
import com.onoh.moviecataloguearcapps.data.local.TvShowEntity
import com.onoh.moviecataloguearcapps.data.remote.response.TvShowResponse
import com.onoh.moviecataloguearcapps.utils.DataDummy

class DetailViewModel(private val appRepository: AppRepository) :ViewModel(){
    private  var movieId:Int =0
     private var tvShowId:Int=0

    fun setSelectedMovie(movieId :Int){
        this.movieId = movieId
    }
    fun setSelectedtvShow(tvShowId :Int){
        this.tvShowId = tvShowId
    }

    fun getDetailMovie():LiveData<MovieEntity> = appRepository.getDetailMovie(movieId)

    fun getDetailTvshow():LiveData<TvShowEntity> = appRepository.getDetailTvshow(tvShowId)
}