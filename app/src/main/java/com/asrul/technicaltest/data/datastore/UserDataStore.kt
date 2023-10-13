package com.asrul.technicaltest.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.asrul.technicaltest.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.userDataStore: DataStore<Preferences> by preferencesDataStore(name = "user")

class UserDataStore(private val context: Context) {

    val user: Flow<User> = context.userDataStore.data
        .map { user ->
            User(
                id = user[ID] ?: "",
                name = user[NAME] ?: "",
                currentBalance = user[CURRENT_BALANCE] ?: 0.0,
            )
        }

    suspend fun setUser(user: User) {
        context.userDataStore.edit {
            it[ID] = user.id
            it[NAME] = user.name
            it[CURRENT_BALANCE] = user.currentBalance
        }

    }

    suspend fun updateCurrentBalance(balance: Double) {
        context.userDataStore.edit {
            it[CURRENT_BALANCE] = balance
        }
    }

    suspend fun setFirstInstall() {
        context.userDataStore.edit {
            it[IS_FIRST_INSTALL] = false
        }
    }

    val isFirstInstall: Flow<Boolean> = context.userDataStore.data
        .map {
            it[IS_FIRST_INSTALL] ?: true
        }

    companion object {
        val ID = stringPreferencesKey("id")
        val NAME = stringPreferencesKey("name")
        val CURRENT_BALANCE = doublePreferencesKey("current_balance")
        val IS_FIRST_INSTALL = booleanPreferencesKey("is_first_install")
    }
}

