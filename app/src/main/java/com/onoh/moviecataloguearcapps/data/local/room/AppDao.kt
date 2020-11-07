package com.onoh.moviecataloguearcapps.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.onoh.moviecataloguearcapps.data.local.entity.MovieEntity
import com.onoh.moviecataloguearcapps.data.local.entity.TvShowEntity
import javax.sql.DataSource

@Dao
interface AppDao {

    @Query("SELECT * FROM moviesentities")
    fun getAllMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM tvshowentities")
    fun getAllTvShows():LiveData<List<TvShowEntity>>

    @Query("SELECT * FROM moviesentities where favorite = 1")
    fun getFavoriteMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM tvshowentities where favorite = 1")
    fun getFavoriteTvshows(): LiveData<List<TvShowEntity>>

    @Query("SELECT * FROM moviesentities WHERE movieId = :movieId")
    fun getDetailMovie(movieId:Int):LiveData<MovieEntity>

    @Query("SELECT * FROM tvshowentities WHERE tvShowId = :tvShowId")
    fun getDetailTvShow(tvShowId:Int):LiveData<TvShowEntity>

    @Update
    fun updateMovie(movieEntity: MovieEntity)

    @Update
    fun updateTvShow(tvShowEntity: TvShowEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvshows(tvshows: List<TvShowEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailMovies(movies: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailTvshows(tvshows: TvShowEntity)


}