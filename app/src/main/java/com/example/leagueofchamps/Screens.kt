package com.example.leagueofchamps

sealed class Screens(val route: String) {
    object MainScreen : Screens( route = "main_screen")
    object SecondScreen : Screens( route = "second_screen")
    object SettDetail : Screens(route = "sett_detail")
    object IreliaDetail : Screens(route = "irelia_detail")
    object EkkoDetail : Screens(route = "ekko_detail")

}