package android.suitmedia.ui.component

import android.suitmedia.R
import android.suitmedia.ui.theme.Poppins
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithNavigation(navController: NavController, modifier: Modifier = Modifier) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White,
        )
    }
    TopAppBar(
        modifier = modifier.drawBehind {
            val borderSize = 1.dp.toPx()
            drawLine(
                color = Color(0xFFE2E3E4),
                start = Offset(9f, size.height),
                end = Offset(size.width, size.height),
                strokeWidth = borderSize
            )
        },
        title = {
            Box(
                modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                IconButton(
                    modifier = modifier.align(Alignment.CenterStart),
                    onClick = { navController.navigateUp() }) {
                    Icon(
                        modifier = modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                        contentDescription = "Back",
                        tint = Color(0xFF554AF0)
                    )
                }
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = when (currentRoute) {
                        "secondScreen" -> "Second Screen"
                        "thirdScreen" -> "Third Screen"
                        else -> "App"
                    },
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF04021D),
                        fontSize = 18.sp,
                        fontFamily = Poppins
                    ),
                )
            }
        },


        )
}