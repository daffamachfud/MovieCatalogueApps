package com.onoh.moviecataloguearcapps.ui.movie

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onoh.moviecataloguearcapps.BuildConfig
import com.onoh.moviecataloguearcapps.data.AppRepository
import com.onoh.moviecataloguearcapps.data.local.MovieEntity

class MovieViewModel(private val appRepository: AppRepository) : ViewModel() {
    private lateinit var apiKey:String

    fun setApiKey(apiKey:String){
        this.apiKey = apiKey
    }
    fun getMovies():LiveData<List<MovieEntity>> = appRepository.getAllMovies(apiKey)
}