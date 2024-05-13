package com.example.susupractico.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.DockedSearchBar as DockedSearchBar1

/**
 * Created by Jonas Korankye on 3/24/2024.
 */
@Composable
fun HomeScreen(){
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){

        Text("Home Screen")

    }

//    DockedSearchBar(query = "", onQueryChange ={} , onSearch = {  } , active =true , onActiveChange = {  } ) {
//
//    }

}


@Preview(showSystemUi = true)
@Composable
fun displayHome() {
    HomeScreen()
}
