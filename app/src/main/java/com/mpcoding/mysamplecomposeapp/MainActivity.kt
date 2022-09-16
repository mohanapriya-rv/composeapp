package com.mpcoding.mysamplecomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mpcoding.mysamplecomposeapp.ui.navigation.Navigation

/**
 * created by Mohanapriya R on 16-09-2022
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}
