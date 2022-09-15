package com.mpcoding.mysamplecomposeapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mpcoding.mysamplecomposeapp.MainActivity
import com.mpcoding.mysamplecomposeapp.model.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ListScreen.route) {
        composable(route = Screen.ListScreen.route) {
            MainActivity().MainScreen(navController = navController)
        }
        /**
         * name will be argument to be passed
         * /{name}/{age}/{people}/{}
         */
        composable(route = Screen.DetailScreen.route, arguments = listOf(
            navArgument("name") {
                type = NavType.StringType
                defaultValue = "home"
                nullable = true
            }
        )
        ) { entry_ ->
            MainActivity().DetailScreen(entry_.arguments?.getString("name"))
        }

    }
}
