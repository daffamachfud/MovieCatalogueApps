package com.onoh.moviecataloguearcapps.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.onoh.moviecataloguearcapps.R

class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)
    }
}
