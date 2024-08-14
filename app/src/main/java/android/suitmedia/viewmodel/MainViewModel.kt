package android.suitmedia.viewmodel

import android.content.Context
import android.suitmedia.model.data.DataStore
import android.suitmedia.model.data.User
import android.suitmedia.model.remote.ApiService
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeoutException

class MainViewModel(private val apiService: ApiService) : ViewModel() {
    private val dataStore = DataStore

    private val _user = mutableStateOf<List<User>>(emptyList())
    val users : State<List<User>> = _user
    fun saveToDataStore(context: Context, value: String, isSelectedName:Boolean) {
        viewModelScope.launch {
           dataStore.saveToDataStore(context, value, isSelectedName)
        }
    }

    fun getFromDataStore(context: Context,  isSelectedName:Boolean): Flow<String?> {
        return dataStore.getFromDataStore(context, isSelectedName)
    }

    fun resetDataStore(context: Context){
        viewModelScope.launch {
            dataStore.resetAllData(context)
        }
    }

    fun getUsersFromApi(context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = apiService.getUsers(1, 10)
                _user.value = response.data
            } catch (e : TimeoutException){
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                }
            } catch (e : Exception){
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }



}