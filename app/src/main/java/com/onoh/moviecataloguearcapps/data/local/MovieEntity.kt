package com.onoh.moviecataloguearcapps.data.local

data class MovieEntity(
    var movieId:Int?,
    var title:String?,
    var rating:Double?,
    var overview:String?,
    var dateRelease:String?,
    var posterImage:String?
)