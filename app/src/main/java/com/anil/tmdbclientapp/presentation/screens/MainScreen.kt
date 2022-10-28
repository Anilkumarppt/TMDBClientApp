package com.anil.tmdbclientapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.anil.tmdbclientapp.presentation.navigation.TMDBAppScreen
import com.anil.tmdbclientapp.presentation.ui.theme.Purple200

@Composable
fun MainScreen(navController: NavController){

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
           MainTextBoxes(text = "Movies") {
               navController.navigate(TMDBAppScreen.MoviesListScreen.route)
           }
            MainTextBoxes(text = "Artists") {
                System.out.println("Artist")
            }
            MainTextBoxes(text = "TVShows",{})
        }
    }
}

@Composable
fun MainTextBoxes(text:String,textClicked:()->Unit){
    Box(
        Modifier
            .width(350.dp)
            .height(200.dp)
            .padding(16.dp)
            .background(Purple200).
            clickable(
                onClick = {
                    textClicked()
                }
            ),
        contentAlignment = Alignment.Center

    ){
        Text(
            text = text,
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.clickable { textClicked }

        )
    }
}


