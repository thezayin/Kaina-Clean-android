package com.thezayin.kainaclean.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.thezayin.kainaclean.data.api.BotApi
import com.thezayin.kainaclean.data.impl.AuthRepositoryImpl
import com.thezayin.kainaclean.data.impl.BookingRepositoryImpl
import com.thezayin.kainaclean.data.impl.BotRepositoryImpl
import com.thezayin.kainaclean.domain.repository.AuthRepository
import com.thezayin.kainaclean.domain.repository.BookingRepository
import com.thezayin.kainaclean.domain.repository.BotRepository
import com.thezayin.kainaclean.domain.usecases.auth_usecases.AuthenticationUseCases
import com.thezayin.kainaclean.domain.usecases.auth_usecases.FirebaseAuthState
import com.thezayin.kainaclean.domain.usecases.auth_usecases.FirebaseForgetPassword
import com.thezayin.kainaclean.domain.usecases.auth_usecases.FirebaseSignIn
import com.thezayin.kainaclean.domain.usecases.auth_usecases.FirebaseSignOut
import com.thezayin.kainaclean.domain.usecases.auth_usecases.FirebaseSignUp
import com.thezayin.kainaclean.domain.usecases.auth_usecases.GetCurrentUser
import com.thezayin.kainaclean.domain.usecases.auth_usecases.IsUserAuthenticated
import com.thezayin.kainaclean.domain.usecases.booking_usecases.AddBookingUseCase
import com.thezayin.kainaclean.domain.usecases.booking_usecases.BookingUseCases
import com.thezayin.kainaclean.domain.usecases.booking_usecases.GetBookingUseCase
import com.thezayin.kainaclean.domain.usecases.bot_usecases.BotUseCase
import com.thezayin.kainaclean.domain.usecases.bot_usecases.MessageUseCases
import com.thezayin.kainaclean.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideBotApi(): BotApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(BotApi::class.java)
    }

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
    fun provideBookingRepository(fireStore: FirebaseFirestore): BookingRepository {
        return BookingRepositoryImpl(fireStore)
    }

    @Provides
    @Singleton
    fun provideBookingUseCase(repository: BookingRepository) = BookingUseCases(
        getBookingUseCase = GetBookingUseCase(repo = repository),
        addBookingUseCase = AddBookingUseCase(repo = repository)
    )

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

    @Provides
    @Singleton
    fun provideBotRepository(botApi: BotApi): BotRepository {
        return BotRepositoryImpl(botApi)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: BotRepository) =
        MessageUseCases(botUseCase = BotUseCase(repository))
}