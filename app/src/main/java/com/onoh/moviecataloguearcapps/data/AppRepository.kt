package com.onoh.moviecataloguearcapps.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.onoh.moviecataloguearcapps.data.local.MovieEntity
import com.onoh.moviecataloguearcapps.data.local.TvShowEntity
import com.onoh.moviecataloguearcapps.data.remote.RemoteDataSource
import com.onoh.moviecataloguearcapps.data.remote.response.MovieResponse
import com.onoh.moviecataloguearcapps.data.remote.response.MoviesResult
import com.onoh.moviecataloguearcapps.data.remote.response.TvShowsResult

class AppRepository private constructor(private val remoteDataSource: RemoteDataSource) : AppDataSource {

    companion object{
        @Volatile
        private var instance:AppRepository?=null
        fun getInstance(remoteDataSource: RemoteDataSource):AppRepository =
            instance?: synchronized(this){
                instance?: AppRepository(remoteDataSource)
            }
    }

    override fun getAllMovies(apiKey:String): LiveData<List<MovieEntity>> {
       val movieResults = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllMovies(apiKey,object :RemoteDataSource.LoadMovieCallback{
            override fun onAllMoviesReceived(movieResult: List<MoviesResult?>?) {
                val movieList = ArrayList<MovieEntity>()
                if (movieResult != null) {
                    for(response in movieResult){
                        val movie = MovieEntity(
                            response?.id,response?.title,response?.voteAverage,response?.overview,response?.releaseDate,response?.posterPath
                        )
                        movieList.add(movie)
                    }
                    movieResults.postValue(movieList)
                }
            }
        })
        return movieResults
    }

    override fun getDetailMovie(movieId: Int): LiveData<MovieEntity> {
        TODO("Not yet implemented")
    }

    override fun getAllTvshows(apiKey:String): LiveData<List<TvShowEntity>> {
        val tvResults = MutableLiveData<List<TvShowEntity>>()
        remoteDataSource.getAllTvShow(apiKey,object :RemoteDataSource.LoadTvCallback{
            override fun onAllTvShowsReceived(tvShowsResult: List<TvShowsResult?>?) {
                val tvList = ArrayList<TvShowEntity>()
                if (tvShowsResult != null) {
                    for(response in tvShowsResult){
                        val tvShow = TvShowEntity(response?.id,response?.originalName,response?.voteAverage,response?.overview,null,null,response?.posterPath)
                        tvList.add(tvShow)
                    }
                    tvResults.postValue(tvList)
                }
            }
        })
        return tvResults
    }

    override fun getDetailTvshow(tvShowId: Int): LiveData<TvShowEntity> {
        TODO("Not yet implemented")
    }
}