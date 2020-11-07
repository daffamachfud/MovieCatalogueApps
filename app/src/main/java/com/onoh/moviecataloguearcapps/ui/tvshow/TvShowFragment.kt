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
import com.onoh.moviecataloguearcapps.vo.Status
import com.onoh.moviecataloguearcapps.vo.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_tv_show.*
import kotlinx.android.synthetic.main.fragment_tv_show.progress_bar


class TvShowFragment : Fragment() {

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
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this,factory)[TvshowViewModel::class.java]
            val tvShowAdapter = TvShowAdapter()


            progress_bar.visibility = View.VISIBLE
            viewModel.getTvShows().observe(viewLifecycleOwner, {
                if(it != null){
                    when(it.status){
                        Status.LOADING ->progress_bar.visibility = View.VISIBLE
                        Status.SUCCESS-> {
                            progress_bar.visibility = View.GONE
                            tvShowAdapter.setTvShow(it.data)
                            tvShowAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            progress_bar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
            with(rv_tv_show){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

}
