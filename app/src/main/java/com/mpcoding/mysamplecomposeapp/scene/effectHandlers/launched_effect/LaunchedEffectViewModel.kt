package com.mpcoding.mysamplecomposeapp.scene.effectHandlers.launched_effect

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

/**
 * created by mohanapriya
 */
class LaunchedEffectViewModel : ViewModel() {
    fun getData() {
        viewModelScope.launch {
            _sharedFlow.emit(MyEvents.ShowSnackBar("error"))
        }
    }

    private val _sharedFlow = MutableSharedFlow<MyEvents>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            _sharedFlow.emit(MyEvents.ShowSnackBar("error"))
        }
    }

    sealed class MyEvents {
        data class ShowSnackBar(val message: String) : MyEvents()
        data class Navigate(val route: String) : MyEvents()
    }
}