package com.onoh.moviecataloguearcapps.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onoh.moviecataloguearcapps.R
import com.onoh.moviecataloguearcapps.data.local.MovieEntity
import com.onoh.moviecataloguearcapps.vo.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_MOVIE = "extra_movie"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        setSupportActionBar(toolbar_detail)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        btn_close_detail.setOnClickListener{finish()}

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this,factory)[DetailViewModel::class.java]
        val extras = intent.extras
        if(extras != null){
            val movieId = extras.getInt(EXTRA_MOVIE)
            if(movieId!= 0){
                progressBar.visibility = View.VISIBLE
                viewModel.setSelectedMovie(movieId)
                setupDetail(viewModel.getDetailMovie())
            }
        }
    }

    private fun setupDetail(movie: LiveData<MovieEntity>) {
        movie.observe(this, {
            Glide.with(this)
                .load(IMAGE_URL+it.posterImage)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(img_detail_film)

            tv_detail_movie_title.text = it.title
            tv_detail_movie_tagline.text = it.dateRelease
            tv_detail_movie_overview.text = it.overview
            progressBar.visibility = View.GONE
        })
    }

}
