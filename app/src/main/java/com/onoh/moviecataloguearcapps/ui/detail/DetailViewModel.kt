package com.onoh.moviecataloguearcapps.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.onoh.moviecataloguearcapps.data.AppRepository
import com.onoh.moviecataloguearcapps.data.local.entity.MovieEntity
import com.onoh.moviecataloguearcapps.data.local.entity.TvShowEntity
import com.onoh.moviecataloguearcapps.vo.Resource

class DetailViewModel(private val appRepository: AppRepository) :ViewModel(){
  val movieId = MutableLiveData<Int>()
    val tvshowId = MutableLiveData<Int>()

    fun setSelectedMovie(movieId :Int){
        this.movieId.value = movieId
    }
    fun setSelectedtvShow(tvshowId :Int){
        this.tvshowId.value= tvshowId
    }

    fun getDetailMovie():LiveData<Resource<MovieEntity>> =Transformations.switchMap(movieId){
        appRepository.getDetailMovie(it)
    }

    fun getDetailTvshow():LiveData<Resource<TvShowEntity>> =Transformations.switchMap(tvshowId){
        appRepository.getDetailTvshow(it)
    }

    fun setMovieFavorite(){
        val movieResource = getDetailMovie().value
        if(movieResource != null){
           val movie = movieResource.data
            if(movie!=null){
                val newState = movie.favorite
                if (newState != null) {
                    appRepository.setFavoriteMovie(movie,newState)
                }
            }
        }
    }

    fun setTvFavorite(){
        val tvResource = getDetailTvshow().value
        if(tvResource != null){
            val tv = tvResource.data
            if(tv!=null){
                val newState = tv.favorite
                if (newState != null) {
                    appRepository.setFavoriteTvShow(tv,newState)
                }
            }
        }
    }
}