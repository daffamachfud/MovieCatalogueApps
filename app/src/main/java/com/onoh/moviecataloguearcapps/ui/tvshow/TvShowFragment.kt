package com.onoh.moviecataloguearcapps.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.onoh.moviecataloguearcapps.BuildConfig
import com.onoh.moviecataloguearcapps.R
import com.onoh.moviecataloguearcapps.ui.movie.MovieViewModel
import com.onoh.moviecataloguearcapps.ui.movie.MoviesFragment
import com.onoh.moviecataloguearcapps.vo.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_tv_show.*
import kotlinx.android.synthetic.main.fragment_tv_show.progress_bar

/**
 * A simple [Fragment] subclass.
 */
class TvShowFragment : Fragment() {

    companion object{
        const val API_KEY = BuildConfig.API_KEY
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(activity != null){
            val factory = ViewModelFactory.getInstance()
            val viewModel = ViewModelProvider(this,factory)[TvshowViewModel::class.java]
            val tvShowAdapter = TvShowAdapter()

            viewModel.setApiKey(MoviesFragment.API_KEY)
            progress_bar.visibility = View.VISIBLE
            viewModel.getTvShows().observe(viewLifecycleOwner, Observer {
                progress_bar.visibility = View.GONE
                tvShowAdapter.setTvShow(it)
                tvShowAdapter.notifyDataSetChanged()
            })
            with(rv_tv_show){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

}
