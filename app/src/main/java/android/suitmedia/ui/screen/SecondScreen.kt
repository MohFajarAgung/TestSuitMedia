package android.suitmedia.ui.screen

import android.suitmedia.model.data.DataStore
import android.suitmedia.ui.component.CustomButton
import android.suitmedia.ui.component.Header
import android.suitmedia.ui.theme.Poppins
import android.suitmedia.viewmodel.MainViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SecondScreen(
    mainViewModel: MainViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
){

    val context = LocalContext.current
    val name = mainViewModel.getFromDataStore(context,false).collectAsState(initial = "Default value")
    val selectedUser = mainViewModel.getFromDataStore(context, true).collectAsState(initial = "Default value")
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Box(modifier = modifier
            .align(Alignment.TopCenter)
            .padding(20.dp)){
            name.value?.let { Header(name = it) }
        }
        selectedUser.value?.let {
            Text(
                text = it,
                style = TextStyle(
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF04021D),
                    fontSize = 24.sp,
                    fontFamily = Poppins
                ),
            )
        }
          Box(modifier = modifier
              .align(Alignment.BottomCenter)
              .padding(30.dp), contentAlignment = Alignment.BottomCenter){
          CustomButton(text = "Choose a User", onClick = {
              navController.navigate(route = "thirdScreen")
          })
          }
      }

}