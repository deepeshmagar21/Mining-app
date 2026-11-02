package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.myapplication.model.sampleMiningItems
import com.example.myapplication.ui.screens.*
import com.example.myapplication.ui.theme.MyApplicationTheme

enum class Screen {
    Welcome,
    Location,
    Consent,
    VerificationIntro,
    NameInput,
    PhoneInput,
    Otp,
    Home,
    ItemDetail,
    Profile
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TempestMiningApp()
                }
            }
        }
    }
}

@Composable
fun TempestMiningApp() {
    var currentScreen by remember { mutableStateOf(Screen.Welcome) }
    var userName by remember { mutableStateOf("Adam Ahmed") }
    var userPhone by remember { mutableStateOf("+222 36 00 00 00") }
    var selectedItem by remember { mutableStateOf(sampleMiningItems.last()) }

    when (currentScreen) {
        Screen.Welcome -> {
            WelcomeScreen(
                onGetStarted = { currentScreen = Screen.Location },
                onLogin = { currentScreen = Screen.PhoneInput }
            )
        }

        Screen.Location -> {
            BackHandler { currentScreen = Screen.Welcome }
            LocationScreen(
                onContinue = { currentScreen = Screen.Consent }
            )
        }

        Screen.Consent -> {
            BackHandler { currentScreen = Screen.Location }
            ConsentScreen(
                onConfirm = { currentScreen = Screen.VerificationIntro }
            )
        }

        Screen.VerificationIntro -> {
            BackHandler { currentScreen = Screen.Consent }
            VerificationIntroScreen(
                onContinue = { currentScreen = Screen.NameInput }
            )
        }

        Screen.NameInput -> {
            BackHandler { currentScreen = Screen.VerificationIntro }
            NameInputScreen(
                onContinue = { enteredName ->
                    if (enteredName.isNotBlank()) userName = enteredName
                    currentScreen = Screen.PhoneInput
                }
            )
        }

        Screen.PhoneInput -> {
            BackHandler { currentScreen = Screen.NameInput }
            PhoneInputScreen(
                onContinue = { enteredPhone ->
                    if (enteredPhone.isNotBlank()) userPhone = enteredPhone
                    currentScreen = Screen.Otp
                }
            )
        }

        Screen.Otp -> {
            BackHandler { currentScreen = Screen.PhoneInput }
            OtpScreen(
                onVerified = { currentScreen = Screen.Home }
            )
        }

        Screen.Home -> {
            HomeScreen(
                userName = userName,
                onItemClick = { item ->
                    selectedItem = item
                    currentScreen = Screen.ItemDetail
                },
                onProfileClick = { currentScreen = Screen.Profile }
            )
        }

        Screen.ItemDetail -> {
            BackHandler { currentScreen = Screen.Home }
            ItemDetailScreen(
                item = selectedItem,
                onBack = { currentScreen = Screen.Home }
            )
        }

        Screen.Profile -> {
            BackHandler { currentScreen = Screen.Home }
            ProfileScreen(
                userName = userName,
                phone = userPhone,
                onBack = { currentScreen = Screen.Home },
                onLogout = { currentScreen = Screen.Welcome }
            )
        }
    }
}
