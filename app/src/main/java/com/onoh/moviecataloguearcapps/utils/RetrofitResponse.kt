package com.onoh.moviecataloguearcapps.utils

import android.util.Log
import com.onoh.moviecataloguearcapps.BuildConfig
import com.onoh.moviecataloguearcapps.data.remote.response.MovieResponse
import com.onoh.moviecataloguearcapps.data.remote.response.MoviesResult
import com.onoh.moviecataloguearcapps.network.RetrofitClient
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitResponse {
    fun loadMovies():ArrayList<List<MoviesResult?>?>{
        val list = ArrayList<List<MoviesResult?>?>()
        try {
            RetrofitClient.api().getAllMovie(BuildConfig.API_KEY).enqueue(object: Callback<MovieResponse>{
                override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                    if (response.isSuccessful){
                        val filmResponse = response.body()?.results
                        list.add(filmResponse)
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.d("OnFailure",t.message.toString())
                }
            })
        }catch (e:JSONException){
            e.printStackTrace()
        }
        return list
    }
}