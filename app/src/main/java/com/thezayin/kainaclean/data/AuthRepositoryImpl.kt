package com.thezayin.kainaclean.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.thezayin.kainaclean.domain.model.Users
import com.thezayin.kainaclean.domain.repository.AuthRepository
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.time.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val fireStore: FirebaseFirestore
) : AuthRepository {

    private var operationIsSuccessful = false
    override fun isUserAuthenticatedInFirebase(): Boolean {
        return auth.currentUser != null
    }

    override fun getFirebaseAuthState(): Flow<Boolean> = callbackFlow {
        val authListener = FirebaseAuth.AuthStateListener {
            trySend(auth.currentUser == null)
        }
        auth.addAuthStateListener(authListener)
        awaitClose {
            auth.removeAuthStateListener(authListener)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun firebaseSignIn(email: String, password: String): Flow<Response<Boolean>> = flow {
        operationIsSuccessful = false
        try {
            emit(Response.Loading)
            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                operationIsSuccessful = true
            }.await()
            val userId = auth.currentUser?.uid!!
            val userInfo = Users(
                userId,
                email,
                password
            )
            fireStore.collection("users_signIn").document(LocalDateTime.now().toString())
                .set(userInfo)
                .addOnSuccessListener {
                }.await()
            emit(Response.Success(operationIsSuccessful))
        } catch (e: Exception) {
            emit(Response.Failure(e.localizedMessage ?: "Unexpected Error"))
        }
    }

    override fun firebaseSignOut(): Flow<Response<Boolean>> = flow {
        try {
            emit(Response.Loading)
            auth.signOut()
            emit(Response.Success(true))
        } catch (e: Exception) {
            emit(Response.Failure(e.localizedMessage ?: "Unexpected Error"))
        }
    }

    override fun firebaseSignUp(email: String, password: String): Flow<Response<Boolean>> = flow {
        operationIsSuccessful = false
        try {
            emit(Response.Loading)
            auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                operationIsSuccessful = true
            }.await()

            val userId = auth.currentUser?.uid!!
            val userInfo = Users(
                userId,
                email,
                password
            )
            fireStore.collection("users").document(email).set(userInfo).addOnSuccessListener {
            }.await()

            emit(Response.Success(true))
        } catch (e: Exception) {
            emit(Response.Failure(e.localizedMessage ?: "Unexpected Error"))
        }
    }

    override fun firebaseRecoverPassword(email: String): Flow<Response<Boolean>> = flow {
        try {
            emit(Response.Loading)
            auth.sendPasswordResetEmail(email)
            emit(Response.Success(true))
        } catch (e: Exception) {
            emit(Response.Failure(e.localizedMessage ?: "Unexpected Error"))
        }
    }

    override fun getCurrentUser(): String {
        return if (auth.currentUser != null) {
            auth.currentUser!!.uid
        } else {
            ""
        }
    }

}