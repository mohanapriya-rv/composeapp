package com.mpcoding.mysamplecomposeapp.model

/**
 * created by Mohanapriya R on 15-08-2022
 */

sealed class Screen(val route: String, val displayName: String) {
    object ListScreen : Screen("list_screen", "List Screen")
    object TextStylesScreen : Screen("text_style_screen", "Text Screen")
    object StateDetailScreen : Screen("state_detail_screen", "State Detail Screen")
    object ConstraintLayoutDetailScreen :
        Screen("constraint_layout_screen", "Constraint Detail Screen")

    object EffectHandlers : Screen("effect_handlers_screen", "Effect Handlers")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}