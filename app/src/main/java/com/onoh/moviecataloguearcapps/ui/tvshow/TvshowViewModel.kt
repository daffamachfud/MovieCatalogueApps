package com.onoh.moviecataloguearcapps.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onoh.moviecataloguearcapps.data.AppRepository
import com.onoh.moviecataloguearcapps.data.local.entity.TvShowEntity
import com.onoh.moviecataloguearcapps.vo.Resource

class TvshowViewModel(private val appRepository: AppRepository): ViewModel() {
    fun getTvShows():LiveData<Resource<List<TvShowEntity>>> = appRepository.getAllTvshows()
}