package com.nasacompose

sealed class BottomNavItem(
    var title: String,
    var icon: Int,
    var screen_route: String
) {
    object Home: BottomNavItem("Home", R.drawable.ic_home, "home")
    object Curiosity: BottomNavItem("Curiosity", R.drawable.ic_home,"curiosity")
    object Opportunity: BottomNavItem("Opportunity", R.drawable.ic_home,"opportunity")
    object Spirit: BottomNavItem("Spirit", R.drawable.ic_home,"spirit")
    object Favorite: BottomNavItem("Favorite", R.drawable.ic_fav,"favorite")

}