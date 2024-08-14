package android.suitmedia.ui.component

import android.suitmedia.ui.theme.Poppins
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(
    text : String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(12.dp)
){
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        onClick = {onClick()},
        shape = shape,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2B637B))

    ) {
        Text(
            text = text,
            style = TextStyle(
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight(500),
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = Poppins
            ),
        )

    }

}