package com.mpcoding.mysamplecomposeapp.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mpcoding.mysamplecomposeapp.data.MySampleModel


/**
 * created by Mohanapriya R
 */
@Composable
fun SetToolBar(screenName: String, doNavigate: (MySampleModel, NavHostController) -> Unit) {
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .padding(4.dp)
    ) {
        Text(
            text = screenName,
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(0.dp, 3.dp, 0.dp, 0.dp))
                .height(50.dp),
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
        )
    }
    Navigation { mySampleModel, navController ->
        doNavigate(mySampleModel, navController)
    }
}