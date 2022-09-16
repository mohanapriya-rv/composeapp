package com.mpcoding.mysamplecomposeapp.scene

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



/**
 * created by Mohanapriya R on 16-09-2022
 */

/**
 * vertical arrangement
 * horizontal alignment
 */
@Composable
fun MPTextStylesScreen(name: String?) {
    Box(Modifier.padding(20.dp)) {
        Column(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .fillMaxHeight()
                .border(5.dp, Color.DarkGray)
                .padding(5.dp),
//                    .border(5.dp, Color.Magenta)
//                    .padding(5.dp)
//                    .border(5.dp, Color.Blue)
//                    .padding(5.dp)
//                    .height(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {//            Text(text = "Hello", modifier = Modifier.offset(0.dp,20.dp))
//            // spacer allocates space
//            Text(text = "welcome to Android",modifier = Modifier.offset(0.dp,20.dp) )
            Text(text = "Hello", fontSize = 30.sp, color = Color.White)
            Spacer(Modifier.height(50.dp))
            Text(text = "welcome to Android")
        }
    }
}