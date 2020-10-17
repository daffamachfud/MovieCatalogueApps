package com.onoh.moviecataloguearcapps.ui.tvshow

import androidx.lifecycle.ViewModel
import com.onoh.moviecataloguearcapps.data.TvShowEntity
import com.onoh.moviecataloguearcapps.utils.DataDummy

class TvshowViewModel: ViewModel() {
    fun getTvShows():List<TvShowEntity> = DataDummy.generateDummyTvShows()
}