package com.example.susupractico.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.susupractico.R
import com.example.susupractico.components.HeaderText
import com.example.susupractico.components.NormalTextField

/**
 * Created by Jonas Korankye on 3/21/2024.
 */

@Composable
fun SignUpScreen(
    onSignUpClick: () -> Unit,
    onLoginClick: () -> Unit,
    onPrivacyClick: () -> Unit,
    onPolicyClick: () -> Unit
) {

    val (firstName, setFirstName) = rememberSaveable {
        mutableStateOf("")
    }
    val (lastName, setLastName) = rememberSaveable {
        mutableStateOf("")
    }
    val (email, onEmailChange) = rememberSaveable {
        mutableStateOf("")
    }
    val (password, onPasswordChange) = rememberSaveable {
        mutableStateOf("")
    }
    val (confirmPassword, onConfirmPasswordChange) = rememberSaveable {
        mutableStateOf("")
    }
    val (agree, onAgreeChange) = rememberSaveable {
        mutableStateOf(false)
    }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(defaultPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderText(
            text = stringResource(id = R.string.signUp),
            modifier = Modifier
                .padding(vertical = defaultPadding)
                .align(alignment = Alignment.Start)
        )
        NormalTextField(
            value = firstName,
            onValueChange = setFirstName,
            labelText = "FirstName",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(defaultPadding))

        NormalTextField(
            value = lastName,
            onValueChange = setLastName,
            labelText = "LastName",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(defaultPadding))

        NormalTextField(
            value = firstName,
            onValueChange = setFirstName,
            labelText = "FirstName",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(defaultPadding))

        NormalTextField(
            value = email,
            onValueChange = onEmailChange,
            labelText = "Email",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(defaultPadding))

        NormalTextField(
            value = password,
            onValueChange = onPasswordChange,
            labelText = "Password",
            keyboardType = KeyboardType.Password,
            modifier = Modifier.fillMaxWidth()

        )
        Spacer(modifier = Modifier.height(defaultPadding))

        NormalTextField(
            value = confirmPassword,
            onValueChange = onConfirmPasswordChange,
            labelText = "ConfirmPassword",
            keyboardType = KeyboardType.Password,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(defaultPadding))


        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val privacyText = "Privacy"
            val policyText = "Policy"
            val annotatedString = buildAnnotatedString {
                withStyle(SpanStyle(color = MaterialTheme.colorScheme.onBackground)) {
                    append("I Agree with")
                }
                append(" ")

                withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                    pushStringAnnotation(tag = privacyText, privacyText)
                    append(privacyText)
                }
                append(" And ")
                withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                    pushStringAnnotation(tag = policyText, policyText)
                    append(policyText)
                }
            }
            Checkbox(checked = agree, onCheckedChange = onAgreeChange)
            ClickableText(annotatedString) { offset ->
                annotatedString.getStringAnnotations(offset, offset).forEach {
                    when (it.tag) {
                        privacyText -> {
                            Toast.makeText(context, "Privacy Clicked", Toast.LENGTH_LONG).show()
                            onPrivacyClick()
                        }

                        policyText -> {
                            Toast.makeText(context, "Policy Text Clicked", Toast.LENGTH_LONG).show()
                            onPolicyClick()
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(defaultPadding + 8.dp))

        Button(onClick = onSignUpClick, Modifier.fillMaxWidth()) {
            Text("Sign Up")
        }

        Spacer(modifier = Modifier.height(defaultPadding))

        val signInTxt = "Sign In"
        val signInAnnotation = buildAnnotatedString {
            withStyle(SpanStyle(color = MaterialTheme.colorScheme.onBackground)) {
                append("Already have an Account?")
            }
            append("  ")
            withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                pushStringAnnotation(signInTxt, signInTxt)
                append(signInTxt)
            }
        }
        ClickableText(signInAnnotation) { index ->
            signInAnnotation.getStringAnnotations(index, index).forEach {
                if (it.tag == signInTxt) {
                    Toast.makeText(context, "Sign In clicked", Toast.LENGTH_SHORT).show()
                    onLoginClick()
                }
            }
        }


    }
}


@Preview(showSystemUi = true)
@Composable
fun SignUpPreview() {
    SignUpScreen({}, {}, {}, {})

}