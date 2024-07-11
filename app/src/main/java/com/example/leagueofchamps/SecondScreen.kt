package com.example.leagueofchamps

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Atrás", color = Color.White) }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(0xFF1F2A41)
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
        ContentScreen(navController, values)
    }
}
@Composable
fun ContentScreen(navController: NavController, paddingValues: PaddingValues) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color(0xFF151E30))
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            item {
                Logo()

                Text(
                    text = "Personajes favoritos: ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            item {
                CardChamp(
                    imageRes = R.drawable.sett,
                    title = "Sett"
                ) { navController.navigate(route = Screens.SettDetail.route) }
            }
            item {
                CardChamp(
                    imageRes = R.drawable.ireliasi,
                    title = "Irelia"
                ) { navController.navigate(route = Screens.IreliaDetail.route) }
            }
            item {
                CardChamp(
                    imageRes = R.drawable.ekkologo,
                    title = "Ekko"
                ) { navController.navigate(route = Screens.EkkoDetail.route) }
            }
            item {
                Text(
                    text = "Momentos favoritos: ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            item {
                CardMoment(title = "Momento 1", videoID = "ZPCfoCVCx3U", R.string.faker_play)
            }

            item { CardMoment(title = "Momento 2", videoID = "PD9p7hATg_Q", R.string.rox_g2)
                }
            item {
                CardMoment(title = "Momento 3", videoID = "kE4vMbn22I0", R.string.son_robots)
                 }
            item {
                Text(
                    text = "Detalles: ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            item { CardDetail("Acerca Del Juego", imageRes = R.drawable.logolol, R.string.lol_detail) }
            item {
                CardMoment(title = "Mi vida", videoID = "wgXEHMPKKbg", R.string.lol_yo)
            }
            item { CardDetail("Contratame", imageRes = R.drawable.yolanda, R.string.contratame_porfavorrrr) }
        }
    }
}

@Composable
fun Logo() {

    Image(
        painter = painterResource(R.drawable.logolol),
        contentDescription = null, modifier = Modifier
            .size(200.dp)
    )
}

@Composable
fun CardChamp(imageRes: Int, title: String, onClick: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1F2A41)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(75.dp)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White

            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                painter = painterResource(R.drawable.baseline_arrow_forward_ios_24),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(65.dp)
                    .padding(horizontal = 16.dp)
            )
        }
    }

}

@Composable
fun CardMoment(title: String, videoID: String, momento: Int) {
    var myshowDialog by remember { mutableStateOf(false) }
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1F2A41)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                myshowDialog = true
            },
        elevation = CardDefaults.cardElevation(12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White

            )
            Spacer(modifier = Modifier.weight(1f))

            Icon(
                painter = painterResource(R.drawable.baseline_arrow_forward_ios_24),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(65.dp)
                    .padding(horizontal = 16.dp)
            )
        }
    }

    if (myshowDialog) {
        Dialog(
            show = true,
            onClose = { myshowDialog = false }, videoID, momento
        )
    }
}

@Composable
fun CardDetail(title: String, imageRes: Int, detail: Int) {
    var myshowDialog by remember { mutableStateOf(false) }
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1F2A41)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                myshowDialog = true
            },
        elevation = CardDefaults.cardElevation(12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White

            )
            Spacer(modifier = Modifier.weight(1f))

            Icon(
                painter = painterResource(R.drawable.baseline_arrow_forward_ios_24),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(65.dp)
                    .padding(horizontal = 16.dp)
            )
        }
    }

    if (myshowDialog) {
        DetailDialog(
            show = true,
            onClose = { myshowDialog = false }, imageRes, detail
        )
    }
}


@Composable
fun DetailDialog(show: Boolean, onClose: () -> Unit, imageRes: Int, detail: Int) {
    if (show) {
        AlertDialog(
            onDismissRequest = onClose,
            properties = DialogProperties(
                dismissOnClickOutside = true
            ),
            confirmButton = {
                IconButton(onClick = onClose, modifier = Modifier.size(150.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.cerrar),
                        contentDescription = null
                    )
                }
            },
            text = {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(id = imageRes), contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape))
                    val text = stringResource(detail)
                    Text(
                        text = text,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White,
                        textAlign = TextAlign.Justify
                    )
                }
            },
            containerColor = Color(0xFF1F2A41)
        )
    }
}

@Composable
fun Dialog(show: Boolean, onClose: () -> Unit, videoID: String, momento: Int) {
    if (show) {
        AlertDialog(
            onDismissRequest = onClose,
            properties = DialogProperties(
                dismissOnClickOutside = true
            ),
            confirmButton = {
                IconButton(onClick = onClose, modifier = Modifier.size(150.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.cerrar),
                        contentDescription = null
                    )
                }
            },
            text = {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    YouTubePlayer(
                        videoId = videoID,
                        lifecycleOwner = LocalLifecycleOwner.current
                    )
                    val text = stringResource(momento)
                    Text(
                        text = text,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White,
                        textAlign = TextAlign.Justify
                    )
                }
            },
            containerColor = Color(0xFF1F2A41)
        )
    }
}

@Composable
fun MyVidaCard(title: String, imageRes: Int, detail: Int) {
    var myshowDialog by remember { mutableStateOf(false) }
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1F2A41)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                myshowDialog = true
            },
        elevation = CardDefaults.cardElevation(12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White

            )
            Spacer(modifier = Modifier.weight(1f))

            Icon(
                painter = painterResource(R.drawable.baseline_arrow_forward_ios_24),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(65.dp)
                    .padding(horizontal = 16.dp)
            )
        }
    }

    if (myshowDialog) {
        DetailDialog(
            show = true,
            onClose = { myshowDialog = false }, imageRes, detail
        )
    }
}