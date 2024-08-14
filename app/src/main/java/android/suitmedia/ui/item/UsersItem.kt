package android.suitmedia.ui.item

import android.content.Context
import android.suitmedia.R
import android.suitmedia.model.data.User
import android.suitmedia.ui.theme.Poppins
import android.suitmedia.viewmodel.MainViewModel
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import java.util.Locale

@Composable
fun UsersItem(user: User, modifier: Modifier = Modifier, mainViewModel: MainViewModel, context: Context, navController: NavController) {
    user?.let {
        Box(
            modifier = modifier.fillMaxWidth().height(115.dp)
                .drawBehind {
                    val borderSize = 1.dp.toPx()
                    drawLine(
                        color = Color(0xFFE2E3E4),
                        start = Offset(9f, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = borderSize
                    )
                }.clickable {
                    val username = user.first_name + " "+ user.last_name
                    mainViewModel.saveToDataStore(context, username, true)
                    navController.navigateUp()
                }
                ,
            contentAlignment = Alignment.CenterStart,

        ) {
            Row(
                modifier = modifier.padding(horizontal = 30.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier =modifier.clip(CircleShape).size(70.dp),
                    model = it.avatar,
                    placeholder = painterResource(R.drawable.baseline_filter_drama_24), // Icon or image resource as a placeholder
                    error = painterResource(R.drawable.baseline_error_outline_24),
                    contentDescription = "Image from URL",
                )
                Column(
                    modifier.padding(vertical = 5.dp, horizontal = 25.dp)
                ) {
                    Text(
                        text = it.first_name!! + " " + it.last_name,
                        style = TextStyle(
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF04021D),
                            fontSize = 16.sp,
                            fontFamily = Poppins
                        ),
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    Text(
                        text = it.email!!.toUpperCase(),
                        style = TextStyle(
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF686777),
                            fontSize = 10.sp,
                            fontFamily = Poppins
                        ),
                    )

                }
            }
        }

    }
}