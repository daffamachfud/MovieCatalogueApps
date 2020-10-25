package com.onoh.moviecataloguearcapps.utils

import com.onoh.moviecataloguearcapps.data.local.MovieEntity
import com.onoh.moviecataloguearcapps.data.local.TvShowEntity

object DataDummy {
    fun generateDummyMovies():List<MovieEntity>{
        val movies = ArrayList<MovieEntity>()

//        movies.add(
//            MovieEntity(
//            1,
//            "A Start is Born",
//                "Romance",
//            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons."
//            ,"5 October 2018",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg")
//        )
//
//        movies.add(
//            MovieEntity(
//                2,
//                "Alita:Battle Angel",
//                "Animation",
//                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past."
//                ,"2 February 2019",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg")
//        )
//
//        movies.add(
//            MovieEntity(
//                3,
//                "Aquaman",
//                "Action,Adventure,Fantasy",
//                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne."
//                ,"21 December 2018",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg")
//        )
//
//        movies.add(
//            MovieEntity(
//                4,
//                "Bohemian Rhapsody",
//                "Drama,Music",
//                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess."
//                ,"24 October 2018",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg")
//        )
//
//        movies.add(
//            MovieEntity(
//                5,
//                "Creed II",
//                "Drama",
//                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life."
//                ,"21 November 2018",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg")
//        )
//
//        movies.add(
//            MovieEntity(
//                6,
//                "Glass",
//                "Thriller,Drama,Science Fiction",
//                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men."
//                ,"16 January 2019",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg")
//        )
//
//        movies.add(
//            MovieEntity(
//                7,
//                "Ip Man 4:The Finale",
//                "Action,Drama,History",
//                "Following the death of his wife, Ip Man travels to San Francisco to ease tensions between the local kung fu masters and his star student, Bruce Lee, while searching for a better future for his son."
//                ,"19 December 2019",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/swmjF0CQc59K3jdUFzOirXESeGN.jpg")
//        )
//
//        movies.add(
//            MovieEntity(
//                8,
//                "Avengers:Endgame",
//                "Adventure,Science Fiction,Action",
//                "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store."
//                ,"26 April 2019",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/or06FN3Dka5tukK1e9sl16pB3iy.jpg")
//        )
//
//        movies.add(
//            MovieEntity(
//                9,
//                "Black Panther",
//                "Action,Adventure,Fantasy,Science Fiction",
//                "King T'Challa returns home from America to the reclusive, technologically advanced African nation of Wakanda to serve as his country's new leader. However, T'Challa soon finds that he is challenged for the throne by factions within his own country as well as without. Using powers reserved to Wakandan kings, T'Challa assumes the Black Panther mantel to join with girlfriend Nakia, the queen-mother, his princess-kid sister, members of the Dora Milaje (the Wakandan 'special forces') and an American secret agent, to prevent Wakanda from being dragged into a world war."
//                ,"16 February 2018",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/uxzzxijgPIY7slzFvMotPv8wjKA.jpg")
//        )
//
//        movies.add(
//            MovieEntity(
//                10,
//                "Mulan",
//                "Action,Adventure,Fantasy,Drama",
//                "When the Emperor of China issues a decree that one man per family must serve in the Imperial Chinese Army to defend the country from Huns, Hua Mulan, the eldest daughter of an honored warrior, steps in to take the place of her ailing father. She is spirited, determined and quick on her feet. Disguised as a man by the name of Hua Jun, she is tested every step of the way and must harness her innermost strength and embrace her true potential."
//                ,"4 September 2020",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/aKx1ARwG55zZ0GpRvU2WrGrCG9o.jpg")
//        )
//
        return movies
    }

    fun generateDummyTvShows():List<TvShowEntity>{
        val tvShows = ArrayList<TvShowEntity>()

//        tvShows.add(
//            TvShowEntity(
//            1,
//            "Game Of Thrones",
//            "Sci-Fi&Fantasy,Drama,Action &Adventure,Mystery",
//            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
//                "6",
//                "8",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg")
//        )
//
//        tvShows.add(
//            TvShowEntity(
//                2,
//                "Peaky Blinders",
//                "Drama,Crime",
//                "A gangster family epic set in 1919 Birmingham, England and centered on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby, who means to move up in the world.",
//                "6",
//                "5",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/6PX0r5TRRU5y0jZ70y1OtbLYmoD.jpg")
//        )
//
//        tvShows.add(
//            TvShowEntity(
//                3,
//                "The Simpsons",
//                "Animation,Comedy,Family,Drama",
//                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
//                "4",
//                "32",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/qcr9bBY6MVeLzriKCmJOv1562uY.jpg")
//        )
//
//        tvShows.add(
//            TvShowEntity(
//                4,
//                "Dragon Ball Z",
//                "Sci&Fi,Animation,Comedy",
//                "Five years have passed since the fight with Piccolo Jr., and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans.",
//                "38",
//                "1",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/f2zhRLqwRLrKhEMeIM7Z5buJFo3.jpg")
//        )
//
//        tvShows.add(
//            TvShowEntity(
//                5,
//                "The Walking Dead",
//                "Action,Drama,Sci-Fi&Fantasy",
//                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
//                "22",
//                "10",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/qgjP2OrrX9gc6M270xdPnEmE9tC.jpg")
//        )
//
//        tvShows.add(
//            TvShowEntity(
//                6,
//                "The Flash",
//                "Drama,Sci-Fi&Fantasy",
//                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
//                "19",
//                "6",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg")
//        )
//
//        tvShows.add(
//            TvShowEntity(
//                7,
//                "Money Heist",
//                "Drama,Crime",
//                "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing.",
//                "16",
//                "2",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/MoEKaPFHABtA1xKoOteirGaHl1.jpg")
//        )
//
//        tvShows.add(
//            TvShowEntity(
//                8,
//                "Stranger Things",
//                "Mystery,Sci-Fi&Fantasy,Drama",
//                "When a young boy vanishes, a small town uncovers a mystery involving secret experiments, terrifying supernatural forces, and one strange little girl.",
//                "8",
//                "3",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/x2LSRK2Cm7MZhjluni1msVJ3wDF.jpg")
//        )
//
//        tvShows.add(
//            TvShowEntity(
//                9,
//                "Naruto",
//                "Animation,Comedy,Action,Drama",
//                "In another world, ninja are the ultimate power, and in the Village Hidden in the Leaves live the stealthiest ninja in the land. Twelve years earlier, the fearsome Nine-Tailed Fox terrorized the village and claimed many lives before it was subdued and its spirit sealed within the body of a baby boy. That boy, Naruto Uzumaki, has grown up to become a ninja-in-training who's more interested in pranks than in studying ninjutsu.. but Naruto is determined to become the greatest ninja ever!",
//                "62",
//                "4",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/vauCEnR7CiyBDzRCeElKkCaXIYu.jpg")
//        )
//
//        tvShows.add(
//            TvShowEntity(
//                10,
//                "Naruto Shippuden",
//                "Animation,Comedy,Drama",
//                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
//                "87",
//                "1",
//                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg")
//        )

        return tvShows
    }
}