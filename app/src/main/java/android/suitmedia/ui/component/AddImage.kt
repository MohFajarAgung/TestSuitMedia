package android.suitmedia.ui.component

import android.suitmedia.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun AddImage(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(50.dp)
) {
    Box(
        modifier = modifier
            .clip(shape)
            .clickable {

            }
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_photo),
            contentDescription = "Logo Image",
            modifier = modifier
                .size(150.dp)
                .padding(16.dp),
        )
    }

}