package android.suitmedia.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithNavigation(navController: NavController, modifier: Modifier = Modifier) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    TopAppBar(
        title = {
            Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                IconButton(
                    modifier = modifier.align(Alignment.CenterStart),
                    onClick = { navController.navigateUp() }) {
                    Icon(
                        modifier = modifier.size(48.dp),
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "Back",
                        tint = Color.Gray
                    )
                }
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = when (currentRoute) {
                        "secondScreen" -> "Second Screen"
                        "thirdScreen" -> "Third Screen"
                        else -> "App"
                    },
                    textAlign = TextAlign.Center
                )
            }
        },
        navigationIcon = {
            if (navController.previousBackStackEntry != null) {


            } else null
        },


        )
}