package com.onoh.moviecataloguearcapps.ui.tvshow

import org.junit.Assert
import org.junit.Before
import org.junit.Test


class TvshowViewModelTest {

    private lateinit var viewModel: TvshowViewModel

    @Before
    fun setUp() {
        viewModel = TvshowViewModel()
    }

    @Test
    fun getTvShows() {
        val tvShow = viewModel.getTvShows()
        Assert.assertNotNull(tvShow)
        Assert.assertEquals(10, tvShow.size)
    }
}