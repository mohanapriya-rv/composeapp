package com.mpcoding.mysamplecomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.mpcoding.mysamplecomposeapp.model.Screen
import com.mpcoding.mysamplecomposeapp.ui.navigation.SetToolBar
import com.mpcoding.mysamplecomposeapp.ui.theme.MyAppTheme

/**
 * created by Mohanapriya R on 16-09-2022
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }

    @Composable
    fun MyApp() {
        val currentScreen = Screen.ListScreen.displayName
        MyAppTheme {
            Scaffold(topBar = {
                SetToolBar(currentScreen) { mySampleModel, navController ->
                    redirectToCorrespondingScreen(mySampleModel.id, navController)
                }
            }) { paddingValues ->
                paddingValues.calculateTopPadding()
            }
        }
    }

    private fun redirectToCorrespondingScreen(id: Int, navController: NavHostController) {
        when (id) {
            1 -> {
                navController.navigate(Screen.TextStylesScreen.route)
            }
            2 -> {
                navController.navigate(Screen.StateDetailScreen.route)
            }
            3 -> {
                navController.navigate(Screen.ConstraintLayoutDetailScreen.route)
            }
            4 -> {
                navController.navigate(Screen.EffectHandlers.route)
            }
        }
    }

}
