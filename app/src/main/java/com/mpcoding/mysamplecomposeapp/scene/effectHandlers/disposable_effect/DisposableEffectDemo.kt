package com.mpcoding.mysamplecomposeapp.scene.effectHandlers.disposable_effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

@Composable

fun DisposableEffectDemo() {
    val lifecycleOwner = LocalLifecycleOwner.current

    /**
     * creating observers on every recomposition is costly operation
     * we can put inside launched effect but we can't
     */
//    val observer = LifecycleEventObserver { _, event ->
//        if (event == Lifecycle.Event.ON_START) {
//            println("on start called")
//        }
//        if (event == Lifecycle.Event.ON_PAUSE) {
//            println("on pause called")
//        }
    DisposableEffect(key1 = lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_START) {
                println("on start called")
            }
            if (event == Lifecycle.Event.ON_PAUSE) {
                println("on pause called")
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        /**  when composition leaves it will be disposed
         */
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}