package com.onoh.moviecataloguearcapps.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onoh.moviecataloguearcapps.data.AppRepository
import com.onoh.moviecataloguearcapps.data.local.entity.MovieEntity
import com.onoh.moviecataloguearcapps.vo.Resource

class MovieViewModel(private val appRepository: AppRepository) : ViewModel() {
    fun getMovies():LiveData<Resource<List<MovieEntity>>> = appRepository.getAllMovies()
}