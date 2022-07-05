package com.mpcoding.mysamplecomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFFF2F2f2))
            ) {
                Image(
                    painterResource(
                        id = R.drawable.food
                    ), modifier = Modifier
                        .height(200.dp)
                        .padding(10.dp),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Happy Meal", style = TextStyle(
                            color = Color.Green, fontSize = TextUnit.Unspecified
                        )
                    )
                    Spacer(modifier = Modifier.padding(top = 10.dp))
                    Text(text = "1200 Calories ")
                    Spacer(modifier = Modifier.padding(top = 10.dp))
                    Text(text = "Rupee 10.0")
                    Spacer(modifier = Modifier.padding(top = 10.dp))

                }
            }
        }
    }
}
