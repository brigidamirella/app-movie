package com.example.themovie.model

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "movie")
@Parcelize
data class Movie(
    @SerializedName("id")
    val id: String?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("poster_path")
    val poster: String?,

    @SerializedName("backdrop_path")
    val backdrop: String?,

    @SerializedName("release_date")
    val release: String?,

    @SerializedName("overview")
    val overview: String?,

    var isFavorites: Boolean = false
) : Parcelable {
    constructor() : this("", "", "", "", "", "")
}