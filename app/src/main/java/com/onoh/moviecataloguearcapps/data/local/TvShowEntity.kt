package com.onoh.moviecataloguearcapps.data.local

data class TvShowEntity(
    var tvShowId:Int?,
    var title:String?,
    var rating: Double?,
    var description:String?,
    var episodes:Int?,
    var season:Int?,
    var posterImage:String?
)