package android.suitmedia.ui.screen

import android.suitmedia.ui.item.UsersItem
import android.suitmedia.viewmodel.MainViewModel
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ThirdScreen(mainViewModel: MainViewModel,navController: NavController, modifier: Modifier = Modifier) {
    val users by mainViewModel.users
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        mainViewModel.getUsersFromApi(context = context)
    }


    LazyColumn(modifier = modifier
        .fillMaxSize()
        .padding(20.dp)){
        items(users) {
            UsersItem(user = it, mainViewModel = mainViewModel, context = context, navController = navController)
        }
    }
}