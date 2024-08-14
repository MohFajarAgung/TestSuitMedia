package android.suitmedia.viewmodel

import android.content.Context
import android.suitmedia.model.data.DataStore
import android.suitmedia.model.remote.ApiService
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val dataStore = DataStore
    fun saveToDataStore(context: Context, value: String) {
        viewModelScope.launch {
           dataStore.saveToDataStore(context, value)
        }
    }

    fun getFromDataStore(context: Context): Flow<String?> {
        return dataStore.getFromDataStore(context)
    }

}