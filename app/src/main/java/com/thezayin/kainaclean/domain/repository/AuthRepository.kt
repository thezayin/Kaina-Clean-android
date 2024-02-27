package com.thezayin.kainaclean.domain.repository

import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun isUserAuthInFirebase(): Boolean

    fun getFirebaseAuthState(): Flow<Boolean>

    fun firebaseSignIn(email: String, password: String): Flow<Response<Boolean>>

    fun firebaseSignOut(): Flow<Response<Boolean>>

    fun firebaseSignUp(email: String, password: String): Flow<Response<Boolean>>

}