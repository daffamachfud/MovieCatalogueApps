package com.onoh.moviecataloguearcapps.utils

import com.onoh.moviecataloguearcapps.data.local.MovieEntity
import com.onoh.moviecataloguearcapps.data.local.TvShowEntity
import com.onoh.moviecataloguearcapps.data.remote.response.MoviesResult
import com.onoh.moviecataloguearcapps.data.remote.response.TvShowsResult

object DataDummy {
    fun generateDummyMoviesResponse():List<MoviesResult>{
        val movies = ArrayList<MoviesResult>()
        movies.add(MoviesResult(
            "-","-","-",false,"-",null,"-","-","-",null,
            null,0,false,0
        ))
        movies.add(MoviesResult(
            "-","-","-",false,"-",null,"-","-","-",null,
            null,0,false,0
        ))
        movies.add(MoviesResult(
            "-","-","-",false,"-",null,"-","-","-",null,
            null,0,false,0
        ))
        movies.add(MoviesResult(
            "-","-","-",false,"-",null,"-","-","-",null,
            null,0,false,0
        ))
        movies.add(MoviesResult(
            "-","-","-",false,"-",null,"-","-","-",null,
            null,0,false,0
        ))
        movies.add(MoviesResult(
            "-","-","-",false,"-",null,"-","-","-",null,
            null,0,false,0
        ))
        movies.add(MoviesResult(
            "-","-","-",false,"-",null,"-","-","-",null,
            null,0,false,0
        ))
        movies.add(MoviesResult(
            "-","-","-",false,"-",null,"-","-","-",null,
            null,0,false,0
        ))
        movies.add(MoviesResult(
            "-","-","-",false,"-",null,"-","-","-",null,
            null,0,false,0
        ))
        return movies
    }

    fun generateDummyTvShowsResponse():List<TvShowsResult>{
        val tvShows = ArrayList<TvShowsResult>()
        tvShows.add(TvShowsResult(
            "","","",null,"",null,"","",null,null,"",
            0,0
        ))
        tvShows.add(TvShowsResult(
            "","","",null,"",null,"","",null,null,"",
            0,0
        ))
        tvShows.add(TvShowsResult(
            "","","",null,"",null,"","",null,null,"",
            0,0
        ))
        tvShows.add(TvShowsResult(
            "","","",null,"",null,"","",null,null,"",
            0,0
        ))
        tvShows.add(TvShowsResult(
            "","","",null,"",null,"","",null,null,"",
            0,0
        ))
        tvShows.add(TvShowsResult(
            "","","",null,"",null,"","",null,null,"",
            0,0
        ))
        tvShows.add(TvShowsResult(
            "","","",null,"",null,"","",null,null,"",
            0,0
        ))
        tvShows.add(TvShowsResult(
            "","","",null,"",null,"","",null,null,"",
            0,0
        ))
        tvShows.add(TvShowsResult(
            "","","",null,"",null,"","",null,null,"",
            0,0
        ))
        return tvShows
    }

    fun generateDummyMovies():List<MovieEntity>{
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                1,
                "2067",
                8.0,
                "A lowly utility worker is called to the future by a mysterious radio signal, he must leave his dying wife to embark on a journey that will force him to face his deepest fears in an attempt to change the fabric of reality and save humankind from its greatest environmental crisis yet."
                ,"5 October 2018",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg")
        )

        movies.add(
            MovieEntity(
                2,
                "Alita:Battle Angel",
                7.5,
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past."
                ,"2 February 2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg")
        )

        movies.add(
            MovieEntity(
                3,
                "Aquaman",
                7.0,
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne."
                ,"21 December 2018",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg")
        )

        movies.add(
            MovieEntity(
                4,
                "Bohemian Rhapsody",
                8.5,
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess."
                ,"24 October 2018",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg")
        )

        movies.add(
            MovieEntity(
                5,
                "Creed II",
                6.0,
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life."
                ,"21 November 2018",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg")
        )

        movies.add(
            MovieEntity(
                6,
                "Glass",
                6.0,
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men."
                ,"16 January 2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg")
        )

        movies.add(
            MovieEntity(
                7,
                "Ip Man 4:The Finale",
                6.0,
                "Following the death of his wife, Ip Man travels to San Francisco to ease tensions between the local kung fu masters and his star student, Bruce Lee, while searching for a better future for his son."
                ,"19 December 2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/swmjF0CQc59K3jdUFzOirXESeGN.jpg")
        )

        movies.add(
            MovieEntity(
                7,
                "Ip Man 4:The Finale",
                6.0,
                "Following the death of his wife, Ip Man travels to San Francisco to ease tensions between the local kung fu masters and his star student, Bruce Lee, while searching for a better future for his son."
                ,"19 December 2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/swmjF0CQc59K3jdUFzOirXESeGN.jpg")
        )

        movies.add(
            MovieEntity(
                7,
                "Ip Man 4:The Finale",
                6.0,
                "Following the death of his wife, Ip Man travels to San Francisco to ease tensions between the local kung fu masters and his star student, Bruce Lee, while searching for a better future for his son."
                ,"19 December 2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/swmjF0CQc59K3jdUFzOirXESeGN.jpg")
        )

        movies.add(
            MovieEntity(
                7,
                "Ip Man 4:The Finale",
                6.0,
                "Following the death of his wife, Ip Man travels to San Francisco to ease tensions between the local kung fu masters and his star student, Bruce Lee, while searching for a better future for his son."
                ,"19 December 2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/swmjF0CQc59K3jdUFzOirXESeGN.jpg")
        )

        return movies
    }

    fun generateDummyTvShows():List<TvShowEntity>{
        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(
            TvShowEntity(
            1,
            "Cobra Kai",
            6.0,
            "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                6,
                8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg")
        )

        tvShows.add(
            TvShowEntity(
                1,
                "Game Of Thrones",
                6.0,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                6,
                8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg")
        )

        tvShows.add(
            TvShowEntity(
                1,
                "Game Of Thrones",
                6.0,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                6,
                8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg")
        )

        tvShows.add(
            TvShowEntity(
                1,
                "Game Of Thrones",
                6.0,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                6,
                8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg")
        )

        tvShows.add(
            TvShowEntity(
                1,
                "Game Of Thrones",
                6.0,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                6,
                8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg")
        )

        tvShows.add(
            TvShowEntity(
                1,
                "Game Of Thrones",
                6.0,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                6,
                8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg")
        )

        tvShows.add(
            TvShowEntity(
                1,
                "Game Of Thrones",
                6.0,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                6,
                8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg")
        )

        tvShows.add(
            TvShowEntity(
                1,
                "Game Of Thrones",
                6.0,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                6,
                8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg")
        )

        tvShows.add(
            TvShowEntity(
                1,
                "Game Of Thrones",
                6.0,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                6,
                8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg")
        )

        tvShows.add(
            TvShowEntity(
                1,
                "Game Of Thrones",
                6.0,
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                6,
                8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg")
        )

        return tvShows
    }


}