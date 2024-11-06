package com.example.navigationcontroller

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable

fun ScreenA(navController: NavController){
    Column(
       Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
       Text("Screen A")
        Button(onClick ={
            navController.navigate(Routes.ScreenB)
        }) {
            Text("Go to Screen B") }

    }
}
@Preview(showBackground = true, showSystemUi = true
)
@Composable

fun ScreenAPreview(){
    ScreenA(rememberNavController())
}


