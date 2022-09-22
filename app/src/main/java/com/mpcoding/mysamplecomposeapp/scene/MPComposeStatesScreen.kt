package com.mpcoding.mysamplecomposeapp.scene

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random

/**
 * created by Mohanapriya R on 16-09-2022
 */

/**
 * to explain about states how it is mainted for global instances
 */
@Composable
fun MPComposeStatesScreen() {
    Column(
        modifier = Modifier.padding(PaddingValues(15.dp, 55.dp, 15.dp, 15.dp))
    ) {
        val color = remember {
            mutableStateOf(Color.Yellow)
        }
        /**
         *declare a  state as common for both box and column
         */
        Box(
            modifier = Modifier
                .weight(0.5f)
                .fillMaxSize()
                .background(color.value)

        )
        ColorBox(
            modifier = Modifier
                .weight(0.5f)
                .fillMaxSize()
        ) {
            color.value = it
        }
    }
}
//
///**
// *simple compose function to test
// */
//@Composable
//fun ColorBox(modifier: Modifier = Modifier) {
//    val color = remember {
//        mutableStateOf(Color.Yellow)
//    }
//    Box(modifier = modifier
//        .background(color.value)
//        .clickable {
//            color.value = Color(
//                Random.nextFloat(),
//                Random.nextFloat(),
//                Random.nextFloat(),
//                1f
//            )
//        }) {
//
//    }
//}

@Composable
fun ColorBox(modifier: Modifier = Modifier, updateColor: (Color) -> Unit) {
    Box(modifier = modifier
        .background(Color.Green)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )
        }) {

    }
}
