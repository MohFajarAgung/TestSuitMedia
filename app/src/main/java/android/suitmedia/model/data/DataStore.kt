package android.suitmedia.model.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object DataStore {
    val Context.dataStore by preferencesDataStore(name = "settings")
    suspend fun saveToDataStore(context: Context, value: String) {

        val dataStore = context.dataStore
        val exampleKey = stringPreferencesKey("name_key")

        dataStore.edit { settings ->
            settings[exampleKey] = value
        }
    }
    fun getFromDataStore(context: Context): Flow<String?> {
        val dataStore = context.dataStore
        val exampleKey = stringPreferencesKey("name_key")

        return dataStore.data
            .map { preferences ->
                preferences[exampleKey] ?: "Nama"
            }
    }
}
