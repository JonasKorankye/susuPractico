package com.example.susupractico.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

/**
 * Created by Jonas Korankye on 3/15/2024.
 */
class LoginViewModel: ViewModel() {
    var registrationUIState = mutableStateOf(RegistrationUIState())

    fun onEvent(event:UIEvent) = when (event) {
        is UIEvent.FirstNameChange -> {
            registrationUIState.value = registrationUIState.value.copy(
                firstName = event.firstName
            )
        }

    is UIEvent.LastNameChange -> {
        registrationUIState.value = registrationUIState.value.copy(
            lastName = event.lastName
        )
    }
    is UIEvent.EmailChanged -> {
        registrationUIState.value = registrationUIState.value.copy(
            email = event.email
        )
    }
    is UIEvent.PasswordChanged -> {
        registrationUIState.value = registrationUIState.value.copy(
            password =  event.password
        )
    }

}

}