package com.onoh.moviecataloguearcapps.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.onoh.moviecataloguearcapps.R
import com.onoh.moviecataloguearcapps.vo.Status
import com.onoh.moviecataloguearcapps.vo.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_movie.*


class MoviesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this,factory)[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter()
            progress_bar.visibility = View.VISIBLE
            viewModel.getMovies().observe(viewLifecycleOwner, {
                if(it != null){
                    when(it.status){
                        Status.LOADING ->progress_bar.visibility = View.VISIBLE
                        Status.SUCCESS-> {
                            progress_bar.visibility = View.GONE
                            movieAdapter.setMovie(it.data)
                            movieAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            progress_bar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            })

            with(rv_movies){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }

    }

}
