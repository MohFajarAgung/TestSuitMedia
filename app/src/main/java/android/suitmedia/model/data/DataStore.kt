package android.suitmedia.model.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object DataStore {
    private val Context.dataStore by preferencesDataStore(name = "settings")
    suspend fun saveToDataStore(context: Context, value: String, isNameSelected : Boolean) {

        val dataStore = context.dataStore
        val nameKey = stringPreferencesKey("name_key")
        val nameSelectedKey = stringPreferencesKey("nameselected_key")
        dataStore.edit { settings ->
            if(!isNameSelected){
            settings[nameKey] = value
            }else{
                settings[nameSelectedKey] = value
            }
        }
    }
    fun getFromDataStore(context: Context, isNameSelected: Boolean): Flow<String?> {
        val dataStore = context.dataStore
        val nameKey = stringPreferencesKey("name_key")
        val nameSelectedKey = stringPreferencesKey("nameselected_key")



        return dataStore.data
            .map { preferences ->
            if(!isNameSelected){
               preferences[nameKey] ?: "Nama"
            }else{
                preferences[nameSelectedKey] ?: "Selected User Name"
            }

            }
    }

    suspend fun resetAllData(context: Context) {
        val dataStore = context.dataStore

        dataStore.edit { settings ->
            settings.clear() // hapus data
        }
    }



}
