package com.mpcoding.mysamplecomposeapp.scene.effectHandlers.rememberCoroutineScope

import androidx.compose.material.Button
import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * scope inside  this function will be cleared after this function is cleared
 * launching new coroutine for
 */
@Composable
fun RememberCoroutineScope() {
    val scope = rememberCoroutineScope()
    Button(onClick = {
        scope.launch {
            delay(1000L)
        }
    }) {
    }
}


/**
 * whenever the updatedOnTimeout  method calls rememberUpdatedState will be notified
 * existing job inside launched effect wiill be cancelled and new will updated'
 */
@Composable
fun RememberUpdatedStateDemo(onTimeOut: () -> Unit) {
    val updatedOnTimeout by rememberUpdatedState(newValue = onTimeOut)
    LaunchedEffect(true) {
        delay(300)
        onTimeOut()
    }

}