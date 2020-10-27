package com.onoh.moviecataloguearcapps.network

import com.onoh.moviecataloguearcapps.data.remote.response.DetailMvResponse
import com.onoh.moviecataloguearcapps.data.remote.response.DetailTvShowResponse
import com.onoh.moviecataloguearcapps.data.remote.response.MovieResponse
import com.onoh.moviecataloguearcapps.data.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("movie/popular")
    fun getAllMovie(@Query("api_key") apiKey: String): Call<MovieResponse>

    @GET("movie/{id}")
    fun getDetailMovie(@Path("id") id:Int ,@Query("api_key") apiKey: String): Call<DetailMvResponse>

    @GET("tv/popular")
    fun getAllTvShow(@Query("api_key") apiKey: String): Call<TvShowResponse>

    @GET("tv/{id}")
    fun getDetailTvShow(@Path("id")id:Int,@Query("api_key") apiKey: String):Call<DetailTvShowResponse>

}