package com.thezayin.kainaclean.booking_history.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.thezayin.kainaclean.booking_history.domain.model.BookingHistory
import com.thezayin.kainaclean.booking_history.domain.repository.BookingHistoryRepository
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class BookingHistoryRepositoryImpl @Inject constructor(
    private val fireStore: FirebaseFirestore
) : BookingHistoryRepository {
    override fun getMyBookingFromFireStore(userId: String): Flow<Response<List<BookingHistory>>> =
        callbackFlow {
            Response.Loading
            val snapshotListener = fireStore.collection("bookings").whereEqualTo("userId", userId)
                .addSnapshotListener { snapShot, error ->
                    val response = if (snapShot != null) {
                        val bookingHistoryList = snapShot.toObjects(BookingHistory::class.java)
                        Response.Success<List<BookingHistory>>(bookingHistoryList)
                    } else {
                        Response.Failure(error?.message ?: error.toString())
                    }
                    trySend(response).isSuccess
                }
            awaitClose { snapshotListener.remove() }
        }

    override fun getCurrentBookingFromFireStore(bookingId: String): Flow<Response<BookingHistory>> =
        callbackFlow {
            Response.Loading
            val snapshotListener = fireStore.collection("bookings").document(bookingId)
                .addSnapshotListener { snapShot, error ->
                    val response = if (snapShot != null) {
                        val booking = snapShot.toObject<BookingHistory>()
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