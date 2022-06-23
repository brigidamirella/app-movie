package com.example.themovie.response

import com.squareup.moshi.Json


class FilmesResponse(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "original_title")
    val original_title: String? = null,
    @Json(name = "poster_path")
    val poster_path: String? = null
) : BaseResponse() {

}

