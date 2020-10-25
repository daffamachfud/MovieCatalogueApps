package com.onoh.moviecataloguearcapps.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onoh.moviecataloguearcapps.BuildConfig
import com.onoh.moviecataloguearcapps.R
import com.onoh.moviecataloguearcapps.data.remote.response.MovieResponse
import com.onoh.moviecataloguearcapps.data.remote.response.MoviesResult
import com.onoh.moviecataloguearcapps.data.remote.response.TvShowResponse
import com.onoh.moviecataloguearcapps.data.remote.response.TvShowsResult
import com.onoh.moviecataloguearcapps.network.ApiService
import com.onoh.moviecataloguearcapps.network.RetrofitClient
import com.onoh.moviecataloguearcapps.utils.RetrofitResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RemoteDataSource{
    companion object{
        @Volatile
        private var instance:RemoteDataSource? = null
        fun getInstance():RemoteDataSource= instance?: synchronized(this){
            instance?: RemoteDataSource()
        }
    }

    private val apiService = RetrofitClient.api()

    fun getAllMovies(apiKey:String,callback:LoadMovieCallback) {
        apiService.getAllMovie(apiKey).enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if(response.isSuccessful){
                    callback.onAllMoviesReceived(response.body()?.results)
                }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d("onResponse",t.message.toString())
            }
        })
    }

    fun getAllTvShow(apiKey: String,callback:LoadTvCallback){
        apiService.getAllTvShow(apiKey).enqueue(object : Callback<TvShowResponse>{
            override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                if(response.isSuccessful){
                    callback.onAllTvShowsReceived(response.body()?.results)
                }
            }
            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.d("onResponse",t.message.toString())
            }
        })
    }

    interface LoadMovieCallback{
        fun onAllMoviesReceived(movieResult:List<MoviesResult?>?)
    }

    interface LoadTvCallback{
        fun onAllTvShowsReceived(tvShowsResult: List<TvShowsResult?>?)
    }

}