package com.onoh.moviecataloguearcapps.vo

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onoh.moviecataloguearcapps.data.AppRepository
import com.onoh.moviecataloguearcapps.di.Injection
import com.onoh.moviecataloguearcapps.ui.detail.DetailViewModel
import com.onoh.moviecataloguearcapps.ui.movie.MovieViewModel
import com.onoh.moviecataloguearcapps.ui.tvshow.TvshowViewModel

class ViewModelFactory  private constructor(private val mAppRepository: AppRepository) : ViewModelProvider.NewInstanceFactory() {
    companion object{
        @Volatile
        private var instance:ViewModelFactory? = null

        fun getInstance(context: Context):ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MovieViewModel::class.java)->{
                MovieViewModel(mAppRepository) as T
            }
            modelClass.isAssignableFrom(TvshowViewModel::class.java)->{
                TvshowViewModel(mAppRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java)->{
                DetailViewModel(mAppRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}