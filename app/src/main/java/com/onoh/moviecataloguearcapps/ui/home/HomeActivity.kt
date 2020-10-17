package com.onoh.moviecataloguearcapps.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.onoh.moviecataloguearcapps.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val sectionPagerAdapter = SectionsPagerAdapter(this,supportFragmentManager)
        view_pager.adapter = sectionPagerAdapter
        tabs.setupWithViewPager(view_pager)
    }
}
