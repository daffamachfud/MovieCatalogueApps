package com.onoh.moviecataloguearcapps.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onoh.moviecataloguearcapps.data.AppRepository
import com.onoh.moviecataloguearcapps.data.local.TvShowEntity
import com.onoh.moviecataloguearcapps.utils.DataDummy

class TvshowViewModel(private val appRepository: AppRepository): ViewModel() {

    fun getTvShows():LiveData<List<TvShowEntity>> = appRepository.getAllTvshows()
}