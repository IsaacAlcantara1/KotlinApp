package com.example.leagueofchamps

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EkkoDetail(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Atrás", color = Color.White) }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Black.copy(alpha = 0.9f)
                ),
                navigationIcon = {

                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Atrás",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) { values ->
        EkkoContentDetail(values)
    }
}

@Composable
fun EkkoContentDetail(paddingValues: PaddingValues){
    Box(
        modifier = Modifier
            .fillMaxSize().padding(paddingValues)
            .paint(
                painter = painterResource(id = R.drawable.ekko),
                contentScale = ContentScale.FillBounds
            )
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.7f))
        ){
            item {
                EkkoTitleAndImage()
            }
            item {
                EkkoChampDetail()
            }

        }
    }
}

@Composable
fun EkkoTitleAndImage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Ekko", fontWeight = FontWeight.Bold, fontSize = 30.sp, color = Color.White)

            Spacer(modifier = Modifier.padding(12.dp))

            val recipeImage = painterResource(R.drawable.ekkologo)

            Image(
                painter = recipeImage,
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
        }
    }
}

@Composable
fun EkkoChampDetail() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Detalles:",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = Color.White
        )
        val settText = stringResource(id = R.string.ekko_detail)

        Text(text = settText , modifier = Modifier.padding(all = 16.dp), textAlign = TextAlign.Justify, color = Color.White)
    }
}