package com.example.cinema.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Film (
    val title : String = "Фильм",
    val titleAlternative : String = "Film",
    val avatar : String = "https://avatars.mds.yandex.net/get-ott/1531675/2a0000017cffb7743ceec8cff073880bf531/375x562",
    val createdAt : Int = 2000,
    val country : String = "Россия",
    val description : String = "Описание",
    val genre : List<Genre> = getDefaultGenreList(),
    val duration : Int = 120,
    val budget : Int = 9000000,
    val revenue : Int = 2147483647,
    val releaseDate : Date = Date(System.currentTimeMillis()),
    val actors : List<Actor> = getDefaultActorsList()
) : Parcelable

fun getDefaultActorsList() = listOf(
    Actor("First", "Actor"),
    Actor("Second", "Actor"),
    Actor("Third", "actor")
)

fun getDefaultGenreList() = listOf(
    Genre("Комедия"),
    Genre("Ужасы"),
    Genre("Боевик")
)

fun getFilms() : List<Film> {
    return listOf(
        Film(
            "Триггер",
            "Триггер",
            "https://avatars.mds.yandex.net/get-ott/1672343/2a0000017ff9f92442fa9995bde34a0bf708/146x220",
            2020,
            "Россия",
            "Психолог Артём Стрелецкий — сторонник шоковой терапии в лечении больных. Он считает, что единственный способ для человека решить свои проблемы — это понять себя и перестать себе врать.",
            listOf(
                Genre("Драма")
            ),
            111,
            2313111,
            12355161,
            Date(2020, 11,15),
            listOf(
                Actor("Пётр1", "Павел"),
                Actor("Пётр2", "Павел"),
                Actor("Пётр3", "Павел"),
                Actor("Пётр4", "Павел")
            ),
        ),
        Film(
            "Триггер",
            "Триггер",
            "https://avatars.mds.yandex.net/get-ott/200035/2a0000017f9c7428943efc3e89491e25214f/146x220",
            2020,
            "Россия",
            "Психолог Артём Стрелецкий — сторонник шоковой терапии в лечении больных. Он считает, что единственный способ для человека решить свои проблемы — это понять себя и перестать себе врать.",
            listOf(
                Genre("Драма")
            ),
            111,
            2313111,
            12355161,
            Date(2020, 11,15),
            listOf(
                Actor("Пётр1", "Павел"),
                Actor("Пётр2", "Павел"),
                Actor("Пётр3", "Павел"),
                Actor("Пётр4", "Павел")
            ),
        ),
        Film(
            "Триггер",
            "Триггер",
            "https://avatars.mds.yandex.net/get-ott/236744/2a0000017ea24190c5a11f3421543b20edec/146x220",
            2020,
            "Россия",
            "Психолог Артём Стрелецкий — сторонник шоковой терапии в лечении больных. Он считает, что единственный способ для человека решить свои проблемы — это понять себя и перестать себе врать.",
            listOf(
                Genre("Драма")
            ),
            111,
            2313111,
            12355161,
            Date(2020, 11,15),
            listOf(
                Actor("Пётр1", "Павел"),
                Actor("Пётр2", "Павел"),
                Actor("Пётр3", "Павел"),
                Actor("Пётр4", "Павел")
            ),
        ),
        Film(
            "Триггер",
            "Триггер",
            "https://avatars.mds.yandex.net/get-ott/2439731/2a0000017ff0d160ddf02a0f8a720881195f/146x220",
            2020,
            "Россия",
            "Психолог Артём Стрелецкий — сторонник шоковой терапии в лечении больных. Он считает, что единственный способ для человека решить свои проблемы — это понять себя и перестать себе врать.",
            listOf(
                Genre("Драма")
            ),
            111,
            2313111,
            12355161,
            Date(2020, 11,15),
            listOf(
                Actor("Пётр1", "Павел"),
                Actor("Пётр2", "Павел"),
                Actor("Пётр3", "Павел"),
                Actor("Пётр4", "Павел")
            ),
        ),
        Film(
            "Триггер",
            "Триггер",
            "https://avatars.mds.yandex.net/get-ott/1652588/2a0000017eb9fad29d8ab27b29e36486b54a/146x220",
            2020,
            "Россия",
            "Психолог Артём Стрелецкий — сторонник шоковой терапии в лечении больных. Он считает, что единственный способ для человека решить свои проблемы — это понять себя и перестать себе врать.",
            listOf(
                Genre("Драма")
            ),
            111,
            2313111,
            12355161,
            Date(2020, 11,15),
            listOf(
                Actor("Пётр1", "Павел"),
                Actor("Пётр2", "Павел"),
                Actor("Пётр3", "Павел"),
                Actor("Пётр4", "Павел")
            ),
        ),
    )
}

