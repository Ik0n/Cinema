package com.example.cinema.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cinema.model.GenreRepository
import com.example.cinema.model.GenreRepositoryImpl
import com.example.cinema.model.Repository
import com.example.cinema.model.RepositoryImpl

class GenreViewModel (
    private val liveDataToObserve : MutableLiveData<GenreAppState> = MutableLiveData(),
    private val genreRepositoryImpl : GenreRepository = GenreRepositoryImpl()
) : ViewModel() {

    fun getLiveData() : LiveData<GenreAppState> {
        return liveDataToObserve
    }

    fun getGenre() = getDataFromLocalSource()


    private fun getDataFromLocalSource() {
        liveDataToObserve.value = GenreAppState.Loading
        Thread {
            Thread.sleep(2000)

            liveDataToObserve.postValue(
                GenreAppState.Success(genreRepositoryImpl.getGenreFromLocalStorage())
            )

        }.start()
    }
}