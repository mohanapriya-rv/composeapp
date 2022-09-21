package com.mpcoding.mysamplecomposeapp.scene.effectHandlers.produce_state

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

/**
 * this the same as flow how it will emit and collect the data
 */
@Composable
fun produceState(countUpTo: Int): State<Int> {
    return produceState(initialValue = 0) {
        while (value < countUpTo) {
            delay(1000)
            value++
        }
    }
}

@Composable
fun DerivedStateOfDemo() {
    var counter by remember {
        mutableStateOf(0)
    }
    //  val mySampletext = " my simple text is $counter"

    /**
     *derivedStateOf will cache the string
     *  it wont  be recomputed returns the cached text here
     *  helpful for complex
     */
    val mySampletext by derivedStateOf {
        " my simple text is $counter"
    }
    Button(modifier = Modifier.fillMaxSize(), onClick = {
        counter++
    }) {
        /**
         *after every recomposition this sample text will to be concanated every time
         * whatever operations will be recomposed
         * to prevent that we need to use derived stateof demo
         *
         */
        Text(mySampletext)
    }
}