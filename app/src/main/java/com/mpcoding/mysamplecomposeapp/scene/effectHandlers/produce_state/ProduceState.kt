package com.mpcoding.mysamplecomposeapp.scene.effectHandlers.produce_state

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    Box(modifier = Modifier.padding(PaddingValues(15.dp, 55.dp, 15.dp, 15.dp))) {
        Button(modifier = Modifier
            .fillMaxSize()
            .padding(), onClick = {
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
}