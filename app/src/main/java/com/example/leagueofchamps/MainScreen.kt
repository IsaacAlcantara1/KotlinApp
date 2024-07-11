package com.example.leagueofchamps

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


//0xFF1F2A41

@Composable
fun MainScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.reu),
                contentScale = ContentScale.FillBounds
            )
    )
    {
        Logo(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 50.dp)
                .size(300.dp)
        )

        TextButton(modifier = Modifier.align(Alignment.Center), navController)
    }
}

@Composable
fun Logo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.lollogo),
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun TextButton(modifier: Modifier, navController: NavHostController) {

    IconButton(onClick = {
        navController.navigate(route = Screens.SecondScreen.route)
    }, modifier = modifier.size(500.dp)) {
        Image(
            painter = painterResource(id = R.drawable.lol),
            contentDescription = null
        )
    }
}
