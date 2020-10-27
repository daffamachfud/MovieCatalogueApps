package com.onoh.moviecataloguearcapps.data.remote

import android.util.Log
import android.widget.Toast
import com.onoh.moviecataloguearcapps.BuildConfig
import com.onoh.moviecataloguearcapps.data.remote.response.*
import com.onoh.moviecataloguearcapps.network.RetrofitClient
import com.onoh.moviecataloguearcapps.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource{
    companion object{
        @Volatile
        private var instance:RemoteDataSource? = null
        const val apiKey = BuildConfig.API_KEY
        fun getInstance():RemoteDataSource= instance?: synchronized(this){
            instance?: RemoteDataSource()
        }
    }

    private val apiService = RetrofitClient.api()

    fun getAllMovies(callback:LoadMovieCallback) {
        EspressoIdlingResource.increment()
        apiService.getAllMovie(apiKey).enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if(response.isSuccessful){
                    callback.onAllMoviesReceived(response.body()?.results)

                    EspressoIdlingResource.decrement()
                }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d("onResponse",t.message.toString())
            }
        })
    }

    fun getDetailMovie(id:Int,callback:LoadDetailMovieCallback){
        EspressoIdlingResource.increment()
        apiService.getDetailMovie(id, apiKey).enqueue(object : Callback<DetailMvResponse>{
            override fun onResponse(call: Call<DetailMvResponse>, response: Response<DetailMvResponse>) {
                if(response.isSuccessful){
                    callback.onDetailMovieReceived(response.body())
                    EspressoIdlingResource.decrement()
                }
            }
            override fun onFailure(call: Call<DetailMvResponse>, t: Throwable) {
                Log.d("onResponse",t.message.toString())
            }
        })
    }

    fun getAllTvShow(callback:LoadTvCallback){
        EspressoIdlingResource.increment()
        apiService.getAllTvShow(apiKey).enqueue(object : Callback<TvShowResponse>{
            override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                if(response.isSuccessful){
                    callback.onAllTvShowsReceived(response.body()?.results)
                    EspressoIdlingResource.decrement()
                }
            }
            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.d("onResponse",t.message.toString())
            }
        })
    }

    fun getDetailTvShow(id:Int,callback:LoadDetailTvCallback){
        EspressoIdlingResource.increment()
        apiService.getDetailTvShow(id,apiKey).enqueue(object :Callback<DetailTvShowResponse>{
            override fun onResponse(call: Call<DetailTvShowResponse>, response: Response<DetailTvShowResponse>) {
                if(response.isSuccessful){
                    callback.onDetailTvReceived(response.body())
                    EspressoIdlingResource.decrement()
                }
            }

            override fun onFailure(call: Call<DetailTvShowResponse>, t: Throwable) {
                Log.d("onResponse",t.message.toString())
            }
        })
    }


    interface LoadMovieCallback{
        fun onAllMoviesReceived(movieResult:List<MoviesResult?>?)
    }

    interface LoadDetailMovieCallback{
        fun onDetailMovieReceived(detailMvResult:DetailMvResponse?)
    }


    interface LoadTvCallback{
        fun onAllTvShowsReceived(tvShowsResult: List<TvShowsResult?>?)
    }

    interface LoadDetailTvCallback{
        fun onDetailTvReceived(detailTvShow:DetailTvShowResponse?)
    }

}