package com.nasacompose.presentation.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nasacompose.data.util.BottomNavItem
import com.nasacompose.R
import androidx.compose.material.BottomNavigation
import androidx.compose.ui.Modifier
import com.nasacompose.presentation.ui.curiosity.CuriosityScreen
import com.nasacompose.presentation.ui.opportunity.OpportunityScreen
import com.nasacompose.presentation.ui.spirit.SpiritScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) {
        Box(modifier = Modifier.padding(it)) {
            NavigationGraph(navHostController = navController)
        }
    }
}


@Composable
fun BottomNavigation(navController: NavController) {

    val bottomNavItems = listOf(
        BottomNavItem.Curiosity,
        BottomNavItem.Opportunity,
        BottomNavItem.Spirit,
       // BottomNavItem.Favorite
    )

    BottomNavigation(
        backgroundColor = colorResource(id = R.color.light),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        bottomNavItems.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
              //  selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomNavItem.Curiosity.screen_route
    ) {
        composable(BottomNavItem.Curiosity.screen_route) {
            CuriosityScreen()
        }
        composable(BottomNavItem.Opportunity.screen_route) {
            OpportunityScreen()
        }
        composable(BottomNavItem.Spirit.screen_route) {
            SpiritScreen()
        }
        /*composable(BottomNavItem.Favorite.screen_route) {
            FavoriteScreen()
        }*/
    }
}