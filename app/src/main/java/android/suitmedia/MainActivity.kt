package android.suitmedia

import android.os.Bundle
import android.suitmedia.model.remote.RetrofiClient
import android.suitmedia.ui.screen.AppNavigation
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import android.suitmedia.ui.theme.TestSuitMediaTheme
import android.suitmedia.viewmodel.MainViewModel
import android.suitmedia.viewmodel.ViewModelFactory
import android.view.View
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController

@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        // Menghilangkan navigasi bar
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // Hides the navigation bar
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        val apiService = RetrofiClient.instace
        val mainViewModel = ViewModelProvider(this, ViewModelFactory(apiService))[MainViewModel::class.java]

        setContent {
            TestSuitMediaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    AppNavigation(navController = navController, viewModel = mainViewModel)
                }
            }
        }
    }
}

