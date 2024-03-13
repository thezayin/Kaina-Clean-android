package com.thezayin.kainaclean.bookings.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.thezayin.kainaclean.bookings.domain.model.Bookings
import com.thezayin.kainaclean.bookings.domain.repository.GetBookingsRepository
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class GetBookingsRepositoryImpl @Inject constructor(
    private val fireStore: FirebaseFirestore
) : GetBookingsRepository {
    override fun getMyBookingFromFireStore(userId: String): Flow<Response<List<Bookings>>> =
        callbackFlow {
            Response.Loading
            val snapshotListener = fireStore.collection("bookings").whereEqualTo("userId", userId)
                .addSnapshotListener { snapShot, error ->
                    val response = if (snapShot != null) {
                        val bookingsList = snapShot.toObjects(Bookings::class.java)
                        Response.Success<List<Bookings>>(bookingsList)
                    } else {
                        Response.Failure(error?.message ?: error.toString())
                    }
                    trySend(response).isSuccess
                }
            awaitClose { snapshotListener.remove() }
        }

    override fun getCurrentBookingFromFireStore(bookingId: String): Flow<Response<Bookings>> =
        callbackFlow {
            Response.Loading
            val snapshotListener = fireStore.collection("bookings").document(bookingId)
                .addSnapshotListener { snapShot, error ->
                    val response = if (snapShot != null) {
                        val booking = snapShot.toObject<Bookings>()
                        if (booking != null) {
                            Response.Success(booking)
                        } else {
                            Response.Failure("No booking found")
                        }
                    } else {
                        Response.Failure(error?.message ?: error.toString())
                    }
                    trySend(response).isSuccess
                }
            awaitClose { snapshotListener.remove() }
        }


}