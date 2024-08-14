package android.suitmedia.ui.screen

import android.suitmedia.R
import android.suitmedia.ui.component.AddImage
import android.suitmedia.ui.component.CustomButton
import android.suitmedia.ui.component.CustomTextField
import android.suitmedia.viewmodel.MainViewModel
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun FirstScreen(
    navController: NavController,
    mainViewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    val systemUiController = rememberSystemUiController()
    val palindromeTextState = remember {
        mutableStateOf("")
    }
    val nameTextState = remember {
        mutableStateOf("")
    }

    val showDialogState = remember {
        mutableStateOf(false)
    }
    val showDialogText = remember {
        mutableStateOf("")
    }

    val context = LocalContext.current
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.Transparent,
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bg), // Replace with your image resource
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier.padding(horizontal = 30.dp),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AddImage()
                Spacer(modifier = modifier.height(40.dp))
                CustomTextField(
                    value = nameTextState.value,
                    onTextChange = { nameTextState.value = it },
                    text = "Name",
                    modifier = modifier.padding(vertical = 12.dp)
                )
                CustomTextField(
                    value = palindromeTextState.value,
                    onTextChange = { palindromeTextState.value = it },
                    text = "Palindrome",
                    modifier = Modifier.padding(vertical = 12.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))
                val isPalindrome = arrayOf("kasur rusak", "step on no pets", "put it up")
                CustomButton(
                    text = "CHECK",
                    onClick = {
                        if (palindromeTextState.value.isNotEmpty()) {
                            for (text in isPalindrome) {
                                if (palindromeTextState.value == text) {
                                    showDialogState.value = true
                                    showDialogText.value = "isPalindrome"
                                    break
                                } else {
                                    if (text == isPalindrome[isPalindrome.size - 1]) {
                                        showDialogState.value = true
                                        showDialogText.value = "notPalindrome"
                                    }
                                }
                            }
                        }
                    }
                )
                CustomButton(
                    text = "NEXT",
                    onClick = {
                        if(nameTextState.value.isNotEmpty()){
                            mainViewModel.resetDataStore(context)
                            mainViewModel.saveToDataStore(context, nameTextState.value, false)
                            navController.navigate(route = "secondScreen")
                        }else{
                            Toast.makeText(context, "Isi Nama Anda!!", Toast.LENGTH_SHORT).show()
                        }
                    }
                )
            }
        }

    }
    if (showDialogState.value) {
        AlertDialog(
            onDismissRequest = { },
            title = {
                Text(text = showDialogText.value)
            },
            text = {
                Text(palindromeTextState.value + " " + showDialogText.value)
            },
            confirmButton = {
                Button(
                    onClick = {
                        showDialogState.value = false
                    },
                    colors = ButtonDefaults.buttonColors(Color.Black)
                ) {
                    Text("Cancel")
                }
            },

            )
    }
}



