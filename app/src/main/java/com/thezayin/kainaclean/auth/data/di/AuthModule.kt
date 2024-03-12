package com.thezayin.kainaclean.presentation.auth.data.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.thezayin.kainaclean.presentation.auth.data.repository.AuthRepositoryImpl
import com.thezayin.kainaclean.presentation.auth.domain.repository.AuthRepository
import com.thezayin.kainaclean.presentation.auth.domain.usecases.AuthenticationUseCases
import com.thezayin.kainaclean.presentation.auth.domain.usecases.FirebaseAuthState
import com.thezayin.kainaclean.presentation.auth.domain.usecases.FirebaseForgetPassword
import com.thezayin.kainaclean.presentation.auth.domain.usecases.FirebaseSignIn
import com.thezayin.kainaclean.presentation.auth.domain.usecases.FirebaseSignOut
import com.thezayin.kainaclean.presentation.auth.domain.usecases.FirebaseSignUp
import com.thezayin.kainaclean.presentation.auth.domain.usecases.GetCurrentUser
import com.thezayin.kainaclean.presentation.auth.domain.usecases.IsUserAuthenticated
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AuthModule {
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideFireBaseStore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideFireStorage(): FirebaseStorage {
        return FirebaseStorage.getInstance()
    }

    @Provides
    @Singleton
    fun provideAuthRepository(auth: FirebaseAuth, fireStore: FirebaseFirestore): AuthRepository {
        return AuthRepositoryImpl(auth, fireStore)
    }

    @Provides
    @Singleton
    fun provideAuthUseCase(repository: AuthRepository) = AuthenticationUseCases(
        firebaseAuthState = FirebaseAuthState(repository = repository),
        isUserAuthenticated = IsUserAuthenticated(repository = repository),
        firebaseSignUp = FirebaseSignUp(repository = repository),
        firebaseSignIn = FirebaseSignIn(repository = repository),
        firebaseSignOut = FirebaseSignOut(repository = repository),
        firebaseForgetPassword = FirebaseForgetPassword(repository = repository),
        getCurrentUser = GetCurrentUser(repository = repository)
    )
}