package com.thezayin.kainaclean.auth.domain.repository


import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow


interface AuthRepository {
    fun isUserAuthenticatedInFirebase(): Boolean

    fun getFirebaseAuthState(): Flow<Boolean>

    fun firebaseSignIn(email: String, password: String): Flow<Response<Boolean>>

    fun firebaseSignOut(): Flow<Response<Boolean>>

    fun firebaseSignUp(email: String, password: String): Flow<Response<Boolean>>

    fun firebaseRecoverPassword(email: String): Flow<Response<Boolean>>

    fun getCurrentUser(): String
}