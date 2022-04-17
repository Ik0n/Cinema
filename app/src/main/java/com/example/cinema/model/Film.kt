package com.example.cinema.model

data class Film (
    val title : String = "Title",
    val createdAt : Int = 2000,
    val country : String = "Russia",
    val description : String = "Description",
    val genre : String = "Comedy",
    val actors: List<Actor> = getDefaultActorsList()
)

fun getDefaultActorsList() = listOf(
    Actor("First", "Actor"),
    Actor("Second", "Actor"),
    Actor("Third", "actor")
)

