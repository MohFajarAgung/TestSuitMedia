@file:Suppress("DEPRECATION")

package android.suitmedia.ui.screen

import android.suitmedia.ui.component.*
import android.suitmedia.ui.item.UsersItem
import android.suitmedia.ui.theme.Poppins
import android.suitmedia.viewmodel.MainViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.google.accompanist.swiperefresh.*
import kotlinx.coroutines.*

@Composable
fun ThirdScreen(
    mainViewModel: MainViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val users by mainViewModel.users
    var isRefreshing by remember { mutableStateOf(false) }
    val isLoading by mainViewModel.loading.collectAsState()
    var halaman by remember {
        mutableStateOf(1)
    }
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        mainViewModel.getUsersFromApi(context = context, halaman)
    }
    val coroutineScope = rememberCoroutineScope()
    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing),
        onRefresh = {
            isRefreshing = true
            // Simulasi proses refresh
            coroutineScope.launch {
                halaman++
                delay(1000L) // Menunggu 1 detik
                mainViewModel.getUsersFromApi(context, halaman)
                isRefreshing = false
            }
        },
        modifier = Modifier.fillMaxSize()
    ) {

        if (users.isEmpty()) {
            if (isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else {
                    LazyColumn(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(30.dp), horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        item {
                            Text(
                                modifier = modifier.fillMaxWidth(),
                                text = "Halaman $halaman Kosong",
                                style = TextStyle(
                                    fontStyle = FontStyle.Normal,
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF04021D),
                                    fontSize = 24.sp,
                                    fontFamily = Poppins
                                ),
                                textAlign = TextAlign.Center
                            )
                            CustomButton(text = "Kembali ke halaman sebelumnya",
                                onClick = {
                                    halaman--
                                    mainViewModel.getUsersFromApi(context, halaman)
                                })
                        }

                    }
            }
        } else {
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                items(users) {
                    UsersItem(
                        user = it,
                        mainViewModel = mainViewModel,
                        context = context,
                        navController = navController
                    )
                }
                item {
                    if (halaman != 1) {
                        CustomButton(text = "Kembali ke halaman sebelumnya",
                            onClick = {
                                halaman--
                                mainViewModel.getUsersFromApi(context, halaman)
                            })
                    }
                }

            }

        }
    }


}