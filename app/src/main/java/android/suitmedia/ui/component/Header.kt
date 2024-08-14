package android.suitmedia.ui.component

import android.suitmedia.ui.theme.Poppins
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(
    modifier: Modifier = Modifier,
    name : String
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = modifier.padding(vertical = 2.dp),
            text = "Welcome",
            style = TextStyle(
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight(400),
                color = Color(0xFF04021D),
                fontSize = 12.sp,
                fontFamily = Poppins
            ),
        )
        Text(
            text = name,
            style = TextStyle(
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight(600),
                color = Color(0xFF04021D),
                fontSize = 18.sp,
                fontFamily = Poppins
            ),
        )
    }
}