package com.mpcoding.mysamplecomposeapp.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mpcoding.mysamplecomposeapp.data.MySampleModel


/**
 * created by Mohanapriya R
 */
@Composable
fun SetToolBar(screenName: String, doNavigate: (MySampleModel, NavHostController) -> Unit) {
    Box(modifier = Modifier.background(Color.Blue)) {
        Text(
            text = screenName, modifier = Modifier
                .fillMaxWidth()
                .height(56.dp), Color.White
        )
    }
    Navigation { mySampleModel, navController ->
        doNavigate(mySampleModel, navController)
    }
}