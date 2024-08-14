package android.suitmedia.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextField(
    value: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    shape: Shape = RoundedCornerShape(12.dp)
) {
    BasicTextField(
        value = value,
        onValueChange = onTextChange,
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .background(Color.LightGray)
            .padding(start = 25.dp)
        ,
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 16.sp,
        ),
        singleLine = true,
        decorationBox = { innerTextField ->
            Box(
                modifier = modifier
                    .fillMaxWidth()
                        ,
                contentAlignment = Alignment.CenterStart
            ) {
                if (value.isEmpty()) {
                    // Placeholder Text
                    Text(
                        text = text,
                        style = TextStyle(
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,

                        ),
                    )
                }
                innerTextField()
            }
        }
    )
}