package com.onoh.moviecataloguearcapps.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onoh.moviecataloguearcapps.R
import com.onoh.moviecataloguearcapps.data.local.entity.TvShowEntity
import com.onoh.moviecataloguearcapps.vo.Resource
import com.onoh.moviecataloguearcapps.vo.Status
import com.onoh.moviecataloguearcapps.vo.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.activity_detail_movie.toolbar_detail
import kotlinx.android.synthetic.main.activity_detail_tv_show.*
import kotlinx.android.synthetic.main.activity_detail_tv_show.btn_close_detail
import kotlinx.android.synthetic.main.activity_detail_tv_show.progressBar
import kotlinx.android.synthetic.main.fragment_tv_show.progress_bar

class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
    }

    private lateinit var viewModel: DetailViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)
        setSupportActionBar(toolbar_detail)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        btn_close_detail.setOnClickListener{finish()}
        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this,factory)[DetailViewModel::class.java]
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

    private fun setUpDetail(tvShow: LiveData<Resource<TvShowEntity>>) {
        tvShow.observe(this, {
            if (it != null) {
                when (it.status) {
                    Status.LOADING -> progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> if (it.data != null) {
                        progressBar.visibility = View.GONE
                        Glide.with(this)
                            .load(IMAGE_URL+it.data.posterImage)
                            .apply(
                                RequestOptions.placeholderOf(R.drawable.ic_loading)
                                    .error(R.drawable.ic_error))
                            .into(img_detail_tvshow)

                        tv_detail_tv_title.text = it.data.title
                        tv_detail_tv_overview.text = it.data.description
                    }
                    Status.ERROR -> {
                        progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
        }})
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.getDetailTvshow().observe(this,{
            if (it != null) {
                when (it.status) {
                    Status.LOADING -> progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> if (it.data != null) {
                        progressBar.visibility = View.GONE
                        val state = it.data.favorite
                        if (state != null) {
                            setFavoriteState(state)
                        }
                    }
                    Status.ERROR -> {
                        progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            viewModel.setMovieFavorite()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_border)
        }
    }

}
