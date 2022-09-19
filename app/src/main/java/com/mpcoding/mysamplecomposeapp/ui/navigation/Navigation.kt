package com.mpcoding.mysamplecomposeapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mpcoding.mysamplecomposeapp.model.Screen
import com.mpcoding.mysamplecomposeapp.scene.MPComposeStatesScreen
import com.mpcoding.mysamplecomposeapp.scene.MPConstraintLayoutScreen
import com.mpcoding.mysamplecomposeapp.scene.MPListScreen
import com.mpcoding.mysamplecomposeapp.scene.MPTextStylesScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ListScreen.route) {

        composable(route = Screen.ListScreen.route) {
            MPListScreen(navController = navController)
        }


        /**
         * name will be argument to be passed
         * /{name}/{age}/{people}/{}
         */
        composable(route = Screen.TextStylesScreen.route, arguments = listOf(
            navArgument("name") {
                type = NavType.StringType
                defaultValue = "home"
                nullable = true
            }
        )
        ) { entry_ ->
            MPTextStylesScreen(entry_.arguments?.getString("name"))
        }

        composable(route = Screen.StateDetailScreen.route) {
            MPComposeStatesScreen()
        }

        /**
         * for constraint layout
         */
        composable(route = Screen.ConstraintLayoutDetailScreen.route) {
            MPConstraintLayoutScreen()
        }

    }
}
