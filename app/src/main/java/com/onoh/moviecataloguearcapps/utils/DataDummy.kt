package com.onoh.moviecataloguearcapps.utils

import android.util.Log
import com.onoh.moviecataloguearcapps.BuildConfig
import com.onoh.moviecataloguearcapps.data.local.entity.MovieEntity
import com.onoh.moviecataloguearcapps.data.local.entity.TvShowEntity
import com.onoh.moviecataloguearcapps.data.remote.response.MovieResponse
import retrofit2.Callback
import com.onoh.moviecataloguearcapps.data.remote.response.MoviesResult
import com.onoh.moviecataloguearcapps.data.remote.response.TvShowResponse
import com.onoh.moviecataloguearcapps.data.remote.response.TvShowsResult
import com.onoh.moviecataloguearcapps.network.RetrofitClient
import retrofit2.Call
import retrofit2.Response

object DataDummy {


    fun generateDummyMoviesResponse():List<MoviesResult>{
        val movies = ArrayList<MoviesResult>()
        RetrofitClient.api().getAllMovie(BuildConfig.API_KEY).enqueue(object :Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
               if(response.isSuccessful){
                   val data =response.body()?.results
                   if (data != null) {
                       for(d in data){
                            movies.add(MoviesResult(d?.overview,d?.originalLanguage,d?.originalTitle,d?.video,d?.title,d?.genreIds,d?.posterPath,d?.backdropPath,d?.releaseDate,d?.popularity,d?.voteAverage,d?.id,d?.adult,d?.voteCount))
                       }
                   }
               }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) { Log.d("onResponse",t.message.toString()) }
        })
        return movies
    }

    fun generateDummyTvShowsResponse():List<TvShowsResult>{
        val tvShows = ArrayList<TvShowsResult>()
        RetrofitClient.api().getAllTvShow(BuildConfig.API_KEY).enqueue(object :Callback<TvShowResponse>{
            override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                if(response.isSuccessful){
                    val data = response.body()?.results
                    if(data!=null){
                        for(d in data){
                            tvShows.add(TvShowsResult(d?.firstAirDate,d?.overview,d?.originalLanguage,d?.genreIds,d?.posterPath,d?.originCountry,d?.backdropPath,d?.originalName,d?.popularity,d?.voteAverage,d?.originalName,d?.id,d?.voteCount))
                        }
                    }
                }
            }
            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) { Log.d("onResponse",t.message.toString()) }
        })
        return tvShows
    }

    fun generateDummyMovies():List<MovieEntity>{
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                1,
                "Hard Kill",
                4.3,
                "The work of billionaire tech CEO Donovan Chalmers is so valuable that he hires mercenaries to protect it, and a terrorist group kidnaps his daughter just to get it."
                ,"23 October 2020",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/ugZW8ocsrfgI95pnQ7wrmKDxIe.jpg",false)
        )

        movies.add(
            MovieEntity(
                2,
                "Alita:Battle Angel",
                7.5,
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past."
                ,"2 February 2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",false)
        )

        movies.add(
            MovieEntity(
                3,
                "Aquaman",
                7.0,
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne."
                ,"21 December 2018",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",false)
        )

        movies.add(
            MovieEntity(
                4,
                "Bohemian Rhapsody",
                8.5,
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess."
                ,"24 October 2018",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",false)
        )

        movies.add(
            MovieEntity(
                5,
                "Creed II",
                6.0,
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life."
                ,"21 November 2018",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",false)
        )

        movies.add(
            MovieEntity(
                6,
                "Glass",
                6.0,
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men."
                ,"16 January 2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",false)
        )

        movies.add(
            MovieEntity(
                7,
                "Ip Man 4:The Finale",
                6.0,
                "Following the death of his wife, Ip Man travels to San Francisco to ease tensions between the local kung fu masters and his star student, Bruce Lee, while searching for a better future for his son."
                ,"19 December 2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/swmjF0CQc59K3jdUFzOirXESeGN.jpg",false)
        )

        movies.add(
            MovieEntity(
                7,
                "Ip Man 4:The Finale",
                6.0,
                "Following the death of his wife, Ip Man travels to San Francisco to ease tensions between the local kung fu masters and his star student, Bruce Lee, while searching for a better future for his son."
                ,"19 December 2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/swmjF0CQc59K3jdUFzOirXESeGN.jpg",false)
        )

        movies.add(
            MovieEntity(
                7,
                "Ip Man 4:The Finale",
                6.0,
                "Following the death of his wife, Ip Man travels to San Francisco to ease tensions between the local kung fu masters and his star student, Bruce Lee, while searching for a better future for his son."
                ,"19 December 2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/swmjF0CQc59K3jdUFzOirXESeGN.jpg",false)
        )

        movies.add(
            MovieEntity(
                7,
                "Ip Man 4:The Finale",
                6.0,
                "Following the death of his wife, Ip Man travels to San Francisco to ease tensions between the local kung fu masters and his star student, Bruce Lee, while searching for a better future for his son."
                ,"19 December 2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/swmjF0CQc59K3jdUFzOirXESeGN.jpg",false)
        )

        return movies
    }

    fun generateDummyTvShows():List<TvShowEntity>{
        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(
            TvShowEntity(
            1,
            "The Mandalorian",
            8.4,
            "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
                12,
                1,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",false)
        )

        tvShows.add(
            TvShowEntity(
                1,
                "Game Of Thrones",
                6.0,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                6,
                8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",false)
        )

        tvShows.add(
            TvShowEntity(
                1,
                "Game Of Thrones",
                6.0,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                6,
                8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",false)
        )

        tvShows.add(
            TvShowEntity(
                1,
                "Game Of Thrones",
                6.0,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                6,
                8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",false)
        )

        tvShows.add(
            TvShowEntity(
                1,
                "Game Of Thrones",
                6.0,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                6,
                8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",false)
        )

        tvShows.add(
            TvShowEntity(
                1,
                "Game Of Thrones",
                6.0,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                6,
                8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",false)
        )

        tvShows.add(
            TvShowEntity(
                1,
                "Game Of Thrones",
                6.0,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                6,
                8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",false)
        )

        tvShows.add(
            TvShowEntity(
                1,
                "Game Of Thrones",
                6.0,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                6,
                8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",false)
        )

        tvShows.add(
            TvShowEntity(
                1,
                "Game Of Thrones",
                6.0,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                6,
                8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",false)
        )

        tvShows.add(
            TvShowEntity(
                1,
                "Game Of Thrones",
                6.0,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                6,
                8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",false)
        )

        return tvShows
    }


}