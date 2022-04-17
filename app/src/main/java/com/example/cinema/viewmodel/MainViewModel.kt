package com.example.cinema.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cinema.model.Repository
import com.example.cinema.model.RepositoryImpl
import java.lang.Thread.sleep
import kotlin.random.Random

class MainViewModel(
    private val liveDataToObserve : MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImpl : Repository = RepositoryImpl()
) : ViewModel() {

    fun getLiveData() : LiveData<AppState> {
        return liveDataToObserve
    }

    fun getFilm() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(2000)
            val flag = Random.nextInt(2) == 0
            if (flag) {
                liveDataToObserve.postValue(
                    AppState.Success(repositoryImpl.getFilmFromLocalStorage())
                )
            } else {
                liveDataToObserve.postValue(AppState.Error(Throwable("Erorr")))
            }
        }.start()
    }

}