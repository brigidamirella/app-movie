package com.example.themovie.response

import com.squareup.moshi.Json

class FilmesResult(
    @Json(name = "page")
    val page: Int? = null,
    @Json(name = "total_results")
    val totalResults: Int? = null,
    @Json(name = "total_pages")
    val totalPages: Int? = null,
    @Json(name = "results")
    var results: List<FilmesResponse>? = null
) : BaseResponse()