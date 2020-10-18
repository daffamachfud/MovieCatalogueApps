package com.onoh.moviecataloguearcapps.ui.detail

import com.onoh.moviecataloguearcapps.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailViewModelTest {
//    -Memastikan data movie tidak null
//    -Memastikan jumlah data movie sesua dengan yang diharapkan
//    -Memastikan data tvshow tidak null
//    -Memastikan jumlah data tvshow sesua dengan yang diharapkan

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val movieId  = dummyMovie.movieId
    private val tvShowId  = dummyTvShow.tvShowId


    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedtvShow(tvShowId)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyMovie.movieId)
        val movie = viewModel.getMovie()
        assertNotNull(movie)
        assertEquals(dummyMovie.movieId,movie.movieId)
        assertEquals(dummyMovie.title,movie.title)
        assertEquals(dummyMovie.dateRelease,movie.dateRelease)
        assertEquals(dummyMovie.category,movie.category)
        assertEquals(dummyMovie.description,movie.description)
        assertEquals(dummyMovie.posterImage,movie.posterImage)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedtvShow(dummyTvShow.tvShowId)
        val tvShow = viewModel.getTvShow()
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.tvShowId,tvShow.tvShowId)
        assertEquals(dummyTvShow.title,tvShow.title)
        assertEquals(dummyTvShow.category,tvShow.category)
        assertEquals(dummyTvShow.episodes,tvShow.episodes)
        assertEquals(dummyTvShow.season,tvShow.season)
        assertEquals(dummyTvShow.description,tvShow.description)
        assertEquals(dummyTvShow.posterImage,tvShow.posterImage)
    }
}