package com.onoh.moviecataloguearcapps.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onoh.moviecataloguearcapps.data.AppRepository
import com.onoh.moviecataloguearcapps.data.local.TvShowEntity
import com.onoh.moviecataloguearcapps.utils.DataDummy

class TvshowViewModel(private val appRepository: AppRepository): ViewModel() {
    private lateinit var apiKey:String

    fun setApiKey(apiKey:String){
        this.apiKey = apiKey
    }
    fun getTvShows():LiveData<List<TvShowEntity>> = appRepository.getAllTvshows(apiKey)
}