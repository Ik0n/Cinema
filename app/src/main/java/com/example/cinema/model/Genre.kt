package com.example.cinema.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Genre(val title : String) : Parcelable

fun getGenreList() : List<Genre> {
    return listOf(
        Genre("Комедия"),
        Genre("Ужасы"),
        Genre("Трилер"),
        Genre("Детектив"),
        Genre("Драма"),
        Genre("Фантастика"),
    )
}