package com.mpcoding.mysamplecomposeapp.scene.effectHandlers

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mpcoding.mysamplecomposeapp.scene.effectHandlers.launched_effect.LaunchedEffectViewModel


/**
 * effect handlers -> t-540-2020 | Research Analyst - INH200000394 | Investment Advisor - INA200002429 | NPS - POP232012019 | IRDA - CA0709

Personalized Guidance For Life
Tech-enabled human advice | Dedicated Reo non compose things in compose code
 * SIDE EFFECTS -> escapes the scope of composable functions
 */

var i = 0

@Composable
fun MPEffectHandlers() {
    var text by remember {
        mutableStateOf("")
    }
    MaterialTheme {
        Button(onClick = { text += "#" }) {
            /**
             *below lines need not be recomposed everytime
             */
            i++
            Text(text = text)
        }
        LaunchedEffectHandlers(viewModel = LaunchedEffectViewModel())
    }
}

/**
 * launched effect
 * is coroutine scope
 * whenever the key changes code inside launchedEffect  block will be executed
 * flow collect will be called  everytime recomposition is called
 */

@Composable
fun LaunchedEffectHandlers(viewModel: LaunchedEffectViewModel) {
    var snackBar by remember {
        mutableStateOf(false)
    }

    /**
     *this line is needed to MAKE flow to intialize
     * not sure why
     */
    val suggestedDestinations by viewModel.sharedFlow.collectAsState({})
    val text by remember {
        mutableStateOf("simple Compose")
    }
    MaterialTheme {
        Column {
            if (snackBar) {
                Box(
                    Modifier
                        .height(100.dp)
                        .width(200.dp)
                        .background(Color.Yellow)
                ) {
                    Text(text = "My simple Compose app")
                }
            }

            Button(
                onClick = {},
                Modifier
                    .height(200.dp)
                    .width(100.dp)
            ) {
                Text(text = "simpleButton")
                LaunchedEffect(key1 = text) {
                    println(text)
                    Log.e("priya", text)
                }

                /**
                 * below scope must be intialized only once and will be listening throughout the launched
                Effect handler function irrespective of composition and recomposition
                 */
                /**
                 *never cancel or relaunch till its parent function is destroyed
                 */
                // val viewModel: LaunchedEffectViewModel = viewModel()
                LaunchedEffect(key1 = true) {
                    viewModel.getData()
                    viewModel.sharedFlow.collect { event ->
                        Log.e("priya", "events")
                        when (event) {
                            is LaunchedEffectViewModel.MyEvents.ShowSnackBar -> {
                                Log.e("priya", "snackBar")
                                snackBar = true
                            }
                            is LaunchedEffectViewModel.MyEvents.Navigate -> {

                            }
                        }

                    }
                }
            }
        }
    }
}
