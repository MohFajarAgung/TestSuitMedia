package android.suitmedia

import android.os.Bundle
import android.suitmedia.model.remote.ApiService
import android.suitmedia.ui.screen.AppNavigation
import android.suitmedia.ui.screen.FirstScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import android.suitmedia.ui.theme.TestSuitMediaTheme
import android.suitmedia.viewmodel.MainViewModel
import android.suitmedia.viewmodel.ViewModelFactory
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Make sure the content can extend into the system bars
        WindowCompat.setDecorFitsSystemWindows(window, false)
     val mainViewModel = ViewModelProvider(this,ViewModelFactory())[MainViewModel::class.java]

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

