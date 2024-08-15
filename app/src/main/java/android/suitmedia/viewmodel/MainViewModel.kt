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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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

    private val _loading = MutableStateFlow(false)
    val loading : StateFlow<Boolean> =  _loading

    fun getFromDataStore(context: Context,  isSelectedName:Boolean): Flow<String?> {
        return dataStore.getFromDataStore(context, isSelectedName)
    }

    fun resetDataStore(context: Context){
        viewModelScope.launch {
            dataStore.resetAllData(context)
        }
    }

    fun getUsersFromApi(context: Context, halaman : Int){
        viewModelScope.launch(Dispatchers.IO) {
            _loading.value = true
            try {
                val response = apiService.getUsers(halaman, 10)
                if(response.data.isNotEmpty()){
                    _loading.value = false
                _user.value = response.data
                }else{
                    _user.value = emptyList()
                    _loading.value = false
                }
            } catch (e : TimeoutException){
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                    _loading.value = false

                }
            } catch (e : Exception){
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                    _loading.value = false
                }
            }
        }
    }



}