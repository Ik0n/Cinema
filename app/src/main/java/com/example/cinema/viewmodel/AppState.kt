package com.example.cinema.viewmodel

import com.example.cinema.model.Film

sealed class AppState {
    data class Success(val filmData: Film) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}