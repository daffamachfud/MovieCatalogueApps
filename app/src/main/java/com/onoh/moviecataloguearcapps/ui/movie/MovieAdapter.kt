package com.onoh.moviecataloguearcapps.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onoh.moviecataloguearcapps.R
import com.onoh.moviecataloguearcapps.data.MovieEntity
import com.onoh.moviecataloguearcapps.ui.detail.DetailMovieActivity
import kotlinx.android.synthetic.main.items_list.view.*
import java.util.ArrayList

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listMovie = ArrayList<MovieEntity>()

    fun setMovie(movies: List<MovieEntity>?) {
        if (movies == null) return
        listMovie.clear()
        listMovie.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_list, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovie.size


    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(movie: MovieEntity) {
            with(itemView) {
                tv_item_title.text = movie.title
                tv_item_category.text = movie.category
                tv_item_date_release.text = resources.getString(R.string.release_date,movie.dateRelease)
                setOnClickListener {
                    val intent = Intent(context, DetailMovieActivity::class.java).apply {
                        putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.movieId)
                    }
                    context.startActivity(intent)
                }
                Glide.with(context)
                    .load(movie.posterImage)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_error)
                            .error(R.drawable.ic_error))
                    .into(img_poster)
            }
        }
    }
}