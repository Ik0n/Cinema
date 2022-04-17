package com.example.cinema.viewmodel

import com.example.cinema.model.Film
import com.example.cinema.model.Genre

sealed class AppState {
    data class Success(val filmData: List<Film>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}