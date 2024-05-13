package com.example.susupractico.data

/**
 * Created by Jonas Korankye on 3/15/2024.
 */

sealed class UIEvent {
    data class FirstNameChange(val firstName: String ) :UIEvent()
    data class LastNameChange(val lastName : String) : UIEvent()
    data class EmailChanged(val email: String) : UIEvent()
    data class PasswordChanged(val password: String) : UIEvent()
}