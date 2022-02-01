package com.nasacompose.data.util

import com.nasacompose.R

sealed class BottomNavItem(
    var title: String,
    var icon: Int,
    var screen_route: String
) {
    object Curiosity: BottomNavItem("Curiosity", R.drawable.ic_curiosity,"curiosity")
    object Opportunity: BottomNavItem("Opportunity", R.drawable.ic_opportunity,"opportunity")
    object Spirit: BottomNavItem("Spirit", R.drawable.ic_spirit,"spirit")
    //object Favorite: BottomNavItem("Favorite", R.drawable.ic_fav,"favorite")
}