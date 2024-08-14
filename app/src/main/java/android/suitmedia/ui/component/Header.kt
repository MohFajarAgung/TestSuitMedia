package android.suitmedia.ui.component

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
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = modifier.padding(vertical = 2.dp),
            text = "Welcome",
            style = TextStyle(
                color = Color.Gray,
                fontWeight = FontWeight(400),
                fontSize = 12.sp,

                ),
        )
        Text(
            text = "John Doe",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight(600),
                fontSize = 18.sp,

                ),
        )
    }
}