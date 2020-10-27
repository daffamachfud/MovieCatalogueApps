package com.onoh.moviecataloguearcapps.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onoh.moviecataloguearcapps.R
import com.onoh.moviecataloguearcapps.data.local.TvShowEntity
import com.onoh.moviecataloguearcapps.vo.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail_movie.toolbar_detail
import kotlinx.android.synthetic.main.activity_detail_tv_show.*
import kotlinx.android.synthetic.main.activity_detail_tv_show.btn_close_detail
import kotlinx.android.synthetic.main.activity_detail_tv_show.progressBar

class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)
        setSupportActionBar(toolbar_detail)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        btn_close_detail.setOnClickListener{finish()}
        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this,factory)[DetailViewModel::class.java]
        val extras = intent.extras
        if(extras != null){
            val tvShowId = extras.getInt(EXTRA_TV_SHOW)
            if(tvShowId!= 0){
                progressBar.visibility = View.VISIBLE
                viewModel.setSelectedtvShow(tvShowId)
                setUpDetail(viewModel.getDetailTvshow())
            }
        }
    }

    private fun setUpDetail(tvShow: LiveData<TvShowEntity>) {
        tvShow.observe(this, {
            Glide.with(this)
                .load(IMAGE_URL+it.posterImage)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(img_detail_tvshow)

            tv_detail_tv_title.text = it.title
            tv_detail_tv_overview.text = it.description
            progressBar.visibility = View.GONE
        })
    }

}
