package com.onoh.moviecataloguearcapps.data

data class MovieEntity(
    var movieId:String,
    var title:String,
    var category: String,
    var description:String,
    var dateRelease:String,
    var posterImage:String
)