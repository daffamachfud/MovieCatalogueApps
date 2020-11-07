package com.onoh.moviecataloguearcapps.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.onoh.moviecataloguearcapps.data.AppRepository
import com.onoh.moviecataloguearcapps.data.local.entity.MovieEntity
import com.onoh.moviecataloguearcapps.data.local.entity.TvShowEntity
import com.onoh.moviecataloguearcapps.utils.DataDummy
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
////    -Memastikan data movie tidak null
////    -Memastikan jumlah data movie sesua dengan yang diharapkan
////    -Memastikan data tvshow tidak null
////    -Memastikan jumlah data tvshow sesua dengan yang diharapkan

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val movieId  = dummyMovie.movieId
    private val tvShowId  = dummyTvShow.tvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: AppRepository

    @Mock
    private lateinit var movieObserver: Observer<MovieEntity>
    @Mock
    private lateinit var tvShowObserver: Observer<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(appRepository)
        movieId?.let { viewModel.setSelectedMovie(it) }
        tvShowId?.let { viewModel.setSelectedtvShow(it) }
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie

        Mockito.`when`(movieId?.let { appRepository.getDetailMovie(it) }).thenReturn(movie)
        val movieEntity = viewModel.getDetailMovie().value as MovieEntity
        movieId?.let { Mockito.verify(appRepository).getDetailMovie(it) }
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.dateRelease, movieEntity.dateRelease)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.posterImage, movieEntity.posterImage)
        assertEquals(dummyMovie.title, movieEntity.title)

        viewModel.getDetailMovie().observeForever(movieObserver)
        Mockito.verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTvShow() {
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummyTvShow

        Mockito.`when`(tvShowId?.let { appRepository.getDetailTvshow(it) }).thenReturn(tvShow)
        val tvShowEntity = viewModel.getDetailTvshow().value as TvShowEntity
        tvShowId?.let { Mockito.verify(appRepository).getDetailTvshow(it) }
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.tvShowId, tvShowEntity.tvShowId)
        assertEquals(dummyTvShow.description, tvShowEntity.description)
        assertEquals(dummyTvShow.episodes, tvShowEntity.episodes)
        assertEquals(dummyTvShow.season, tvShowEntity.season)
        assertEquals(dummyTvShow.title, tvShowEntity.title)

        viewModel.getDetailTvshow().observeForever(tvShowObserver)
        Mockito.verify(tvShowObserver).onChanged(dummyTvShow)
    }
}