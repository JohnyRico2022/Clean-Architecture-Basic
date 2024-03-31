package ru.nikita.cleanarchitecturebasic.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nikita.cleanarchitecturebasic.domain.model.SaveUserNameParam
import ru.nikita.cleanarchitecturebasic.domain.usecase.GetUserNameUseCase
import ru.nikita.cleanarchitecturebasic.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {


    private val stateLiveMutable = MutableLiveData<MainState>()
    val stateLive: LiveData<MainState> = stateLiveMutable

    init {
        stateLiveMutable.value = MainState(
            saveResult = false,
            firstName = "",
            lastName = ""
        )
    }


    fun send(event: MainEvent) {
        when (event) {
            is SaveEvent -> {
                save(text = event.text)
            }

            is LoadEvent -> {
                load()

            }
        }
    }

    private fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val result: Boolean = saveUserNameUseCase.execute(param = params)
        stateLiveMutable.value = MainState(
            saveResult = result,
            firstName = stateLiveMutable.value!!.firstName,
            lastName = stateLiveMutable.value!!.lastName
        )
    }

    private fun load() {
        val userName = getUserNameUseCase.execute()
        stateLiveMutable.value = MainState(
            saveResult = stateLiveMutable.value!!.saveResult,
            firstName = userName.firstName,
            lastName = userName.lastName
        )
    }
}