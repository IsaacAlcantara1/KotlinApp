package com.example.leagueofchamps

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavManager() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.MainScreen.route) {
        composable(Screens.MainScreen.route) {
            MainScreen(navController)
        }
        composable(Screens.SecondScreen.route) {
            SecondScreen(navController)
        }

      composable(Screens.SettDetail.route) {
         SettDetail(navController)
      }
      composable(Screens.IreliaDetail.route) {
          IreliaDetail(navController)
      }
      composable(Screens.EkkoDetail.route) {
          EkkoDetail(navController)
      }

    }

}