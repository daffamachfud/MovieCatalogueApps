package com.onoh.moviecataloguearcapps.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onoh.moviecataloguearcapps.R
import com.onoh.moviecataloguearcapps.data.local.TvShowEntity
import kotlinx.android.synthetic.main.activity_detail_movie.toolbar_detail
import kotlinx.android.synthetic.main.activity_detail_tv_show.*
import kotlinx.android.synthetic.main.content_detail_tv_show.*

class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)
        setSupportActionBar(toolbar_detail)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]
        val extras = intent.extras
        if(extras != null){
            val tvShowId = extras.getInt(EXTRA_TV_SHOW)
            if(tvShowId!= 0){
                viewModel.setSelectedtvShow(tvShowId)
                setUpDetail(viewModel.getTvShow())
            }
        }
    }

    private fun setUpDetail(tvShow: TvShowEntity) {
        Glide.with(this)
            .load(tvShow.posterImage)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(img_detail_tvshow)

        tv_title_tv_show_detail.text = tvShow.title
        tv_episodes_detail.text = resources.getString(R.string.number_episodes,tvShow.episodes)
        tv_season_detail.text = resources.getString(R.string.last_season,tvShow.season)
        tv_category_tv_show_detail.text = tvShow.episodes
        tv_desc_tv_show_detail.text = tvShow.description
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
