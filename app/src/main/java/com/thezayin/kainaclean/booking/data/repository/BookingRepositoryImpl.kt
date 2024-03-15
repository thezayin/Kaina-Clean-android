package com.thezayin.kainaclean.booking.data.repository

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.google.firebase.firestore.FirebaseFirestore
import com.thezayin.kainaclean.booking.domain.model.Booking
import com.thezayin.kainaclean.booking.domain.repository.BookingRepository
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject

class BookingRepositoryImpl @Inject constructor(
    private val fireStore: FirebaseFirestore
) : BookingRepository {

    private var operationSuccessFull = false

    @SuppressLint("SimpleDateFormat")
    val sdf = SimpleDateFormat("dd/M/yyyy")
    private val currentDate: String = sdf.format(Date())

    @RequiresApi(Build.VERSION_CODES.O)
    override fun addMyBookingToFireStore(
        userId: String,
        name: String,
        email: String,
        contact: String,
        address: String,
        city: String,
        postCode: String,
        propertyType: String,
        service: String,
        date: String
    ): Flow<Response<Boolean>> = flow {
        operationSuccessFull = false
        try {
            val bookingsId = fireStore.collection("bookings").document().id
            val bookings = Booking(
                userId = userId,
                bookingId = bookingsId,
                name = name,
                email = email,
                contact = contact,
                address = address,
                city = city,
                postCode = postCode,
                propertyType = propertyType,
                service = service,
                date = date,
                status = false,
                remarks = "Pending",
                requestDate = currentDate,
            )
            fireStore.collection("bookings").document(bookingsId).set(bookings)
                .addOnSuccessListener {
                    operationSuccessFull = true
                }.await()
            if (operationSuccessFull) {
                emit(Response.Success(operationSuccessFull))
            } else {
                emit(Response.Failure("unsuccessful: Try again later"))
            }
        } catch (e: Exception) {
            emit(Response.Failure(e.localizedMessage ?: "An unexpected Error"))
        }
    }
}