package com.onoh.moviecataloguearcapps.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.onoh.moviecataloguearcapps.data.remote.RemoteDataSource
import com.onoh.moviecataloguearcapps.utils.DataDummy
import com.onoh.moviecataloguearcapps.utils.LiveDataTestUtil
import org.junit.Test
import org.mockito.Mockito.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.doAnswer
import org.junit.Rule
import org.junit.Assert.*


class AppRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val appRepository = FakeAppRepository(remote)
    private val movieResponse = DataDummy.generateDummyMoviesResponse()
    private val tvResponse = DataDummy.generateDummyTvShowsResponse()

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                .onAllMoviesReceived(movieResponse)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntities = LiveDataTestUtil.getValue(appRepository.getAllMovies())
        verify(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllTvshows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvCallback)
                .onAllTvShowsReceived(tvResponse)
            null
        }.`when`(remote).getAllTvShow(any())
        val tvEntities = LiveDataTestUtil.getValue(appRepository.getAllTvshows())
        verify(remote).getAllTvShow(any())
        assertNotNull(tvEntities)
        assertEquals(tvResponse.size.toLong(), tvEntities.size.toLong())
    }

}