package android.suitmedia.ui.screen

import android.suitmedia.ui.component.TopAppBarWithNavigation
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    
        NavHost(navController = navController, startDestination = "firstScreen") {
            composable("firstScreen") { FirstScreen(navController = navController) }
            composable("secondScreen") { 
                Column {
                    TopAppBarWithNavigation(navController = navController)
                    SecondScreen() }
                }
                
            composable("thirdScreen") { ThirdScreen()}
        }


}