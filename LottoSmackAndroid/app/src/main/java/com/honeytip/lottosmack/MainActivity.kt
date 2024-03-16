package com.honeytip.lottosmack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.honeytip.lottosmack.ui.theme.LottoSmackTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LottoSmackTheme {
                // Use a Surface as the container for our screens
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") { HomeScreen(navController) }
                        composable("main") { MainScreen(navController) }
                        composable("stats") { StatsScreen(navController) }
                        composable("settings") { SettingsScreen(navController) }

                        // Add other destinations as needed
                    }
                }
            }
        }
    }
}

/*UI button
* Lotto max 7
* - - - - - - -
* Random number generate (1-50)
* design
* */