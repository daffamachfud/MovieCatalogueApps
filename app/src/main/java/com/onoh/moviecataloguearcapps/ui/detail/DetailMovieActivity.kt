package com.onoh.moviecataloguearcapps.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onoh.moviecataloguearcapps.R
import com.onoh.moviecataloguearcapps.data.local.MovieEntity
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.content_detail_movies.*

class DetailMovieActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        setSupportActionBar(toolbar_detail)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]
        val extras = intent.extras
        if(extras != null){
            val movieId = extras.getInt(EXTRA_MOVIE)
            if(movieId!= 0){
                viewModel.setSelectedMovie(movieId)
                setupDetail(viewModel.getMovie())
            }
        }
    }

    private fun setupDetail(movie: MovieEntity) {
        Glide.with(this)
            .load(movie.posterImage)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(img_detail_movie)

        tv_title_movie_detail.text = movie.title
        tv_date_movie_detail.text = movie.dateRelease
        tv_category_movie_detail.text = movie.overview
        tv_desc_movie_detail.text = movie.overview
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
