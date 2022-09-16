package com.mpcoding.mysamplecomposeapp.model

/**
 * created by Mohanapriya R on 15-08-2022
 */

sealed class Screen(val route: String) {
    object ListScreen : Screen("list_screen")
    object TextStylesScreen : Screen("text_style_screen")
    object StateDetailScreen : Screen("state_detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}