package com.thezayin.kainaclean.data

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.google.firebase.firestore.FirebaseFirestore
import com.thezayin.kainaclean.domain.model.Quote
import com.thezayin.kainaclean.domain.repository.QuoteRepository
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val fireStore: FirebaseFirestore
) : QuoteRepository {

    private var operationSuccessFull = false

    @SuppressLint("SimpleDateFormat")
    val sdf = SimpleDateFormat("dd/M/yyyy")
    val currentDate = sdf.format(Date())
    override fun getMyQuoteFromFireStore(userId: String): Flow<Response<List<Quote>>> =
        callbackFlow {
            Response.Loading
            val snapshotListener = fireStore.collection("quotes").whereEqualTo("userId", userId)
                .addSnapshotListener { snapShot, error ->
                    val response = if (snapShot != null) {
                        val quoteList = snapShot.toObjects(Quote::class.java)
                        Response.Success<List<Quote>>(quoteList)
                    } else {
                        Response.Failure(error?.message ?: error.toString())
                    }
                    trySend(response).isSuccess
                }
            awaitClose { snapshotListener.remove() }
        }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun addMyQuoteToFireStore(
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
            val quoteId = fireStore.collection("quotes").document().id
            val quote = Quote(
                userId = userId,
                quoteId = quoteId,
                name = name,
                email = email,
                contact = contact,
                address = address,
                city = city,
                postCode = postCode,
                propertyType = propertyType,
                service = service,
                date = date,
                status = "Pending",
                remarks = "Pending",
                requestDate = currentDate,
            )
            fireStore.collection("quotes").document(quoteId).set(quote).addOnSuccessListener {
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