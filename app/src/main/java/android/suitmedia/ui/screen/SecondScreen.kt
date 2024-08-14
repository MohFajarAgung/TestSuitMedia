package android.suitmedia.ui.screen

import android.suitmedia.ui.component.CustomButton
import android.suitmedia.ui.component.Header
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(
    modifier: Modifier = Modifier
){
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Box(modifier = modifier.align(Alignment.TopCenter).padding(20.dp)){
        Header()
        }
        Text(
            text = "Selected User Name",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight(600),
                fontSize = 24.sp,

                ),
        )
          Box(modifier = modifier.align(Alignment.BottomCenter).padding(30.dp), contentAlignment = Alignment.BottomCenter){
          CustomButton(text = "Choose a User", onClick = {  })
          }
      }

}