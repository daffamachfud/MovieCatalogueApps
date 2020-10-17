package com.onoh.moviecataloguearcapps.data

data class TvShowEntity(
    var tvShowId:String,
    var title:String,
    var category: String,
    var description:String,
    var episodes:String,
    var season:String,
    var posterImage:String
)