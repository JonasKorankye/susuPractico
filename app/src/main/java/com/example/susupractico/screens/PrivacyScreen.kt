package com.example.susupractico.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * Created by Jonas Korankye on 3/24/2024.
 */
@Composable
fun PrivacyScreen(onBtnClick:() ->Unit){
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){

        Text("Privacy Screen")
        Button(onClick = { onBtnClick()}) {
            Text("Finish")
        }
    }

}
