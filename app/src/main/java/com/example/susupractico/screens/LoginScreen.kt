package com.example.susupractico.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.susupractico.R
import com.example.susupractico.components.HeaderText
import com.example.susupractico.components.NormalTextField
import com.example.susupractico.ui.theme.SusuPracticoTheme

/**
 * Created by Jonas Korankye on 3/15/2024.
 */
val defaultPadding = 16.dp
val itemSpacing = 8.dp

@Composable
fun LoginScreen(onLoginClick:()-> Unit,onSignUpClick: () -> Unit) {

    val (userName, setUsername) = rememberSaveable {
        mutableStateOf("")
    }
    val (password, setPassword) = rememberSaveable {
        mutableStateOf("")
    }

    val (checkBox, onCheckedChange) = rememberSaveable {
        mutableStateOf(false)
    }

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(defaultPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderText(
            text = stringResource(id = R.string.header_account),
            modifier = Modifier
                .padding(vertical = defaultPadding)
                .align(alignment = Alignment.Start)
        )
        NormalTextField(
            value = userName,
            onValueChange = setUsername,
            labelText = "Username",
            leadingIcon = Icons.Default.Person,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(itemSpacing))

        NormalTextField(
            value = password,
            onValueChange = setPassword,
            labelText = "Password",
            leadingIcon = Icons.Default.Lock,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(itemSpacing))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(checked = checkBox, onCheckedChange = onCheckedChange)
                Text(text = "Remember me")
            }
            TextButton(onClick = {}) {
                Text(text = "Forgot Password?")
            }
        }

        Spacer(modifier = Modifier.height(itemSpacing))

        Button(onClick = { onLoginClick}, modifier = Modifier.fillMaxWidth()) {
            Text("LOGIN")
        }

        AlternativeSignUpOptions(
            onIconClick = {index ->
                          when(index){
                              0 -> {
                                  Toast.makeText(context,"Instagram Login Click",Toast.LENGTH_LONG).show()
                              }
                              1 -> {
                                  Toast.makeText(context,"GitHub Login Click",Toast.LENGTH_SHORT).show()
                              }
                              2 -> {
                                  Toast.makeText(context,"Google Login Click",Toast.LENGTH_LONG).show()
                              }
                          }
            },
            onSignUpClick = {onSignUpClick},
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.BottomCenter)

        )

    }


}

@Composable
fun AlternativeSignUpOptions(
    onIconClick: (index: Int) -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier

) {
    val iconList = listOf(
        R.drawable.icon_instagram,
        R.drawable.icon_github,
        R.drawable.icon_google
    )

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Or Sign in with")

        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            iconList.forEachIndexed { index, iconResId ->
                Icon(
                    painter = painterResource(iconResId),
                    contentDescription = "alt login",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { onIconClick(index) }
                        .clip(CircleShape)
                )
                Spacer(Modifier.width(defaultPadding))
            }
        }
        Spacer(Modifier.height(itemSpacing))

        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text("Don't have an Account?")
            Spacer(Modifier.height(itemSpacing))
            TextButton(onClick = onSignUpClick) {
                Text(text = "Sign In")
            }
        }
    }

}


@Preview(showSystemUi = true)
@Composable
fun PrevSignUp() {
    SusuPracticoTheme {
        LoginScreen({},{})
    }
}