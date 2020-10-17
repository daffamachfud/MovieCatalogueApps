package com.onoh.moviecataloguearcapps.utils

import com.onoh.moviecataloguearcapps.data.MovieEntity

object DataDummy {
    fun generateDummyMovies():List<MovieEntity>{
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
            "m1",
            "A Start is Born",
                "Romance",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons."
            ,"5 October 2018",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg")
        )

        movies.add(
            MovieEntity(
                "m2",
                "Alita:Battle Angel",
                "Animation",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past."
                ,"2 February 2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg")
        )

        movies.add(
            MovieEntity(
                "m3",
                "Aquaman",
                "Action,Adventure,Fantasy",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne."
                ,"21 December 2018",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg")
        )

        movies.add(
            MovieEntity(
                "m4",
                "Bohemian Rhapsody",
                "Drama,Music",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess."
                ,"24 October 2018",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg")
        )

        movies.add(
            MovieEntity(
                "m5",
                "Creed II",
                "Drama",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life."
                ,"21 November 2018",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg")
        )

        movies.add(
            MovieEntity(
                "m6",
                "Glass",
                "Thriller,Drama,Science Fiction",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men."
                ,"16 January 2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg")
        )

        movies.add(
            MovieEntity(
                "m7",
                "Ip Man 4:The Finale",
                "Action,Drama,History",
                "Following the death of his wife, Ip Man travels to San Francisco to ease tensions between the local kung fu masters and his star student, Bruce Lee, while searching for a better future for his son."
                ,"19 December 2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/swmjF0CQc59K3jdUFzOirXESeGN.jpg")
        )

        movies.add(
            MovieEntity(
                "m8",
                "Avengers:Endgame",
                "Adventure,Science Fiction,Action",
                "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store."
                ,"26 April 2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/or06FN3Dka5tukK1e9sl16pB3iy.jpg")
        )

        movies.add(
            MovieEntity(
                "m9",
                "Black Panther",
                "Action,Adventure,Fantasy,Science Fiction",
                "King T'Challa returns home from America to the reclusive, technologically advanced African nation of Wakanda to serve as his country's new leader. However, T'Challa soon finds that he is challenged for the throne by factions within his own country as well as without. Using powers reserved to Wakandan kings, T'Challa assumes the Black Panther mantel to join with girlfriend Nakia, the queen-mother, his princess-kid sister, members of the Dora Milaje (the Wakandan 'special forces') and an American secret agent, to prevent Wakanda from being dragged into a world war."
                ,"16 February 2018",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/uxzzxijgPIY7slzFvMotPv8wjKA.jpg")
        )

        movies.add(
            MovieEntity(
                "m10",
                "Mulan",
                "Action,Adventure,Fantasy,Drama",
                "When the Emperor of China issues a decree that one man per family must serve in the Imperial Chinese Army to defend the country from Huns, Hua Mulan, the eldest daughter of an honored warrior, steps in to take the place of her ailing father. She is spirited, determined and quick on her feet. Disguised as a man by the name of Hua Jun, she is tested every step of the way and must harness her innermost strength and embrace her true potential."
                ,"4 September 2020",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/aKx1ARwG55zZ0GpRvU2WrGrCG9o.jpg")
        )

        return movies
    }
}