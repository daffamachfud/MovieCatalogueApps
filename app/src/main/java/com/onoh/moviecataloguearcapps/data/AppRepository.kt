package com.onoh.moviecataloguearcapps.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.onoh.moviecataloguearcapps.data.local.LocalDataSource
import com.onoh.moviecataloguearcapps.data.local.entity.MovieEntity
import com.onoh.moviecataloguearcapps.data.local.entity.TvShowEntity
import com.onoh.moviecataloguearcapps.data.remote.ApiResponse
import com.onoh.moviecataloguearcapps.data.remote.RemoteDataSource
import com.onoh.moviecataloguearcapps.data.remote.response.*
import com.onoh.moviecataloguearcapps.utils.AppExecutors
import com.onoh.moviecataloguearcapps.vo.Resource

class AppRepository private constructor(private val remoteDataSource: RemoteDataSource,
                                        private val localDataSource: LocalDataSource, private val appExecutors: AppExecutors) : AppDataSource {

    companion object{
        @Volatile
        private var instance:AppRepository?=null
        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): AppRepository =
            instance ?: synchronized(this) {
                instance ?: AppRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllMovies(): LiveData<Resource<List<MovieEntity>>> {
        return object : NetworkBoundResource<List<MovieEntity>, List<MoviesResult?>?>(appExecutors) {

            public override fun loadFromDB(): LiveData<List<MovieEntity>> = localDataSource.getAllMovies()

            override fun shouldFetch(data: List<MovieEntity>?): Boolean = data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MoviesResult?>?>> = remoteDataSource.getAllMovies()


            override fun saveCallResult(data: List<MoviesResult?>?) {
                val movieList = ArrayList<MovieEntity>()
                if (data != null) {
                    for (response in data) {
                        val movie = MovieEntity(response?.id,response?.title,response?.voteAverage,response?.overview,response?.releaseDate,response?.posterPath,false)
                        movieList.add(movie)
                    }
                }

                localDataSource.insertAllMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(movieId: Int): LiveData<Resource<MovieEntity>> {
        return object :NetworkBoundResource<MovieEntity,DetailMvResponse?>(appExecutors){
            override fun loadFromDB(): LiveData<MovieEntity> = localDataSource.getLocalDetailMovie(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean = data == null

            override fun createCall(): LiveData<ApiResponse<DetailMvResponse?>> = remoteDataSource.getDetailMovie(movieId)

            override fun saveCallResult(data: DetailMvResponse?) {
               val movieResult = MovieEntity(data?.id,data?.title,data?.voteAverage,data?.overview,data?.releaseDate,data?.posterPath,false)
                localDataSource.insertMovies(movieResult)
            }
        }.asLiveData()
    }

    override fun getAllTvshows(): LiveData<Resource<List<TvShowEntity>>> {
        return object : NetworkBoundResource<List<TvShowEntity>, List<TvShowsResult?>?>(appExecutors) {

            public override fun loadFromDB(): LiveData<List<TvShowEntity>> = localDataSource.getAllTvShows()

            override fun shouldFetch(data: List<TvShowEntity>?): Boolean = data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvShowsResult?>?>> = remoteDataSource.getAllTvShow()

            override fun saveCallResult(data: List<TvShowsResult?>?) {
                val tvShowList = ArrayList<TvShowEntity>()
                if (data != null) {
                    for (response in data) {
                        val tvShow = TvShowEntity(response?.id,response?.originalName,response?.voteAverage,response?.originalName,0,0,response?.posterPath,false)
                        tvShowList.add(tvShow)
                    }
                }
                localDataSource.insertAllTvShow(tvShowList)
            }
        }.asLiveData()
    }

    override fun getDetailTvshow(tvShowId: Int): LiveData<Resource<TvShowEntity>> {
        return object :NetworkBoundResource<TvShowEntity,DetailTvShowResponse?>(appExecutors){
            override fun loadFromDB(): LiveData<TvShowEntity> = localDataSource.getLocalDetailTvshow(tvShowId)

            override fun shouldFetch(data: TvShowEntity?): Boolean = data == null

            override fun createCall(): LiveData<ApiResponse<DetailTvShowResponse?>> = remoteDataSource.getDetailTvShow(tvShowId)

            override fun saveCallResult(data: DetailTvShowResponse?) {
                val tvResult = TvShowEntity(data?.id,data?.name,data?.voteAverage,data?.overview,data?.numberOfEpisodes,data?.numberOfSeasons,data?.posterPath,false)
                Log.d("onResponseDetailTv",data?.overview.toString())
                localDataSource.insertTvShow(tvResult)
            }
        }.asLiveData()
    }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) = appExecutors.diskIO().execute{
        localDataSource.setFavoriteMovie(movie,state)
    }

    override fun setFavoriteTvShow(tvShow: TvShowEntity, state: Boolean)= appExecutors.diskIO().execute{
        localDataSource.setFavoriteTvShow(tvShow,state)
    }
}