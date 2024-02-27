package com.thezayin.kainaclean.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.thezayin.kainaclean.data.AuthRepositoryImpl
import com.thezayin.kainaclean.domain.repository.AuthRepository
import com.thezayin.kainaclean.domain.usecases.AuthUseCases
import com.thezayin.kainaclean.domain.usecases.FirebaseAuthState
import com.thezayin.kainaclean.domain.usecases.FirebaseSignIn
import com.thezayin.kainaclean.domain.usecases.FirebaseSignOut
import com.thezayin.kainaclean.domain.usecases.FirebaseSignUp
import com.thezayin.kainaclean.domain.usecases.IsUserAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseStore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseStorage(): FirebaseStorage {
        return FirebaseStorage.getInstance()
    }

    @Provides
    @Singleton
    fun provideAuthRepo(auth: FirebaseAuth, firebaseFireStore: FirebaseFirestore): AuthRepository {
        return AuthRepositoryImpl(auth, firebaseFireStore)
    }

    @Singleton
    @Provides
    fun providesAuthUseCases(repositoryImpl: AuthRepositoryImpl) = AuthUseCases(
        isUserAuth = IsUserAuth(repository = repositoryImpl),
        firebaseAuthState = FirebaseAuthState(repositoryImpl),
        firebaseSignIn = FirebaseSignIn(repositoryImpl),
        firebaseSignOut = FirebaseSignOut(repositoryImpl),
        firebaseSignUp = FirebaseSignUp(repositoryImpl)

    )
}