package com.mpcoding.mysamplecomposeapp.scene

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
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
 * Scaffold is used to import existing material components
 * used to create toolbar and bottomNavBar
 */
//                    .border(5.dp, Color.Magenta)
//                    .padding(5.dp)
//                    .border(5.dp, Color.Blue)
//                    .padding(5.dp)
//                    .height(200.dp),
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MPTextStylesScreen(name: String?) {
    Box(Modifier.padding(20.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .border(5.dp, Color.DarkGray)
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "Hello", fontSize = 30.sp, color = Color.Black)
            Spacer(Modifier.height(150.dp))
            Text(text = "welcome to Android", fontSize = 30.sp, color = Color.Black)
            /**
             * to show snackBar
             */
            Spacer(Modifier.height(15.dp))
            val scaffoldState = rememberScaffoldState()
            var textFieldState by remember {
                mutableStateOf("")
            }
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = textFieldState,
                        onValueChange = { textFieldState = it },
                        label =
                        { Text(text = "pls enter text") }, singleLine = true
                    )
                }
            }
            Spacer(Modifier.height(15.dp))

            Button(onClick = {}) {
                Text(text = "pls greet me")
            }
        }
    }

}