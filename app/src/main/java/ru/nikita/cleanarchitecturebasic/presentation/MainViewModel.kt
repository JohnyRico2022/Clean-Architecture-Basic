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

    //Предохраняем MutableLiveData от записи из вне этого класса
    private val _resultLive = MutableLiveData<String>()
    val resultLive: LiveData<String> = _resultLive

    init {
        Log.d("MyLog", "VM created")
    }

    // Этот метод вызывается, кагда связанная с VM активити уничтожается
    override fun onCleared() {
        super.onCleared()
        Log.d("MyLog", "VM destroy")
    }

    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val result: Boolean = saveUserNameUseCase.execute(param = params)
        _resultLive.value = "Save result = $result"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        _resultLive.value = "${userName.firstName} ${userName.lastName}"
    }
}