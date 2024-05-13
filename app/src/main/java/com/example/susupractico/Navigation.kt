package com.example.susupractico

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.susupractico.screens.HomeScreen
import com.example.susupractico.screens.LoginScreen
import com.example.susupractico.screens.PolicyScreen
import com.example.susupractico.screens.PrivacyScreen
import com.example.susupractico.screens.SignUpScreen

/**
 * Created by Jonas Korankye on 3/24/2024.
 */

sealed class Route {
    data class LoginScreen(val name: String = "Login") : Route()
    data class SignUpScreen(val name: String = "Login") : Route()
    data class PrivacyScreen(val name: String = "Login") : Route()
    data class PolicyScreen(val name: String = "Login") : Route()
    data class HomeScreen(val name: String = "Login") : Route()
}

@Composable
fun MyNavigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Route.LoginScreen().name
    ) {
        composable(route = Route.LoginScreen().name) {

            LoginScreen(onLoginClick = {
                navHostController.navigate(
                    Route.HomeScreen().name
                )
            },
                onSignUpClick = {
                    navHostController.navigate(
                        Route.SignUpScreen().name
                    )
                })
        }
        composable(route = Route.SignUpScreen().name) {
            SignUpScreen(
                onSignUpClick = {
                    navHostController.navigate(Route.HomeScreen().name)
                },
                onLoginClick = {
                    navHostController.navigate(Route.LoginScreen().name)
                },
                onPrivacyClick = { navHostController.navigate(Route.PrivacyScreen().name) },
                onPolicyClick = { navHostController.navigate(Route.PolicyScreen().name) })
        }
        composable(route = Route.PrivacyScreen().name) {
            PrivacyScreen {navHostController.navigateUp()}
        }
        composable(route = Route.PolicyScreen().name) {
            PolicyScreen {navHostController.navigateUp()}
        }
        composable(route = Route.HomeScreen().name) {
            HomeScreen()
        }

    }
}