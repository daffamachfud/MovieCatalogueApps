package com.onoh.moviecataloguearcapps.ui.movie

import androidx.lifecycle.ViewModel
import com.onoh.moviecataloguearcapps.data.MovieEntity
import com.onoh.moviecataloguearcapps.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovies():List<MovieEntity> = DataDummy.generateDummyMovies()
}