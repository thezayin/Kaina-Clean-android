package com.thezayin.kainaclean.quote.data.repository

import android.annotation.SuppressLint
import com.google.firebase.firestore.FirebaseFirestore
import com.thezayin.kainaclean.quote.domain.model.QuoteService
import com.thezayin.kainaclean.quote.domain.repository.QuoteServiceRepository
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject

@Suppress("NAME_SHADOWING")
class QuoteServiceRepositoryImpl @Inject constructor(val fireStore: FirebaseFirestore) :
    QuoteServiceRepository {

    private var operationSuccessFull = false

    @SuppressLint("SimpleDateFormat")
    val sdf = SimpleDateFormat("dd/MM/yyyy")
    private val currentDate: String = sdf.format(Date())

    override fun addQuoteService(
        userId: String,
        serviceType: String,
        address: String,
        quote: String,
    ): Flow<Response<Boolean>> = flow {
        operationSuccessFull = false
        try {
            val quoteId = fireStore.collection("quotes").document().id
            val quote = QuoteService(
                userId = userId,
                quoteId = quoteId,
                address = address,
                serviceType = serviceType,
                status = false,
                currentDate = currentDate,
                remarks = "Pending",
                quote = quote,
            )
            fireStore.collection("quotes").document(quoteId).set(quote)
                .addOnSuccessListener {
                    operationSuccessFull = true
                }.await()
            if (operationSuccessFull) {
                emit(Response.Success(operationSuccessFull))
            } else {
                emit(Response.Failure("unsuccessful: Try again later"))
            }
        } catch (e: Exception) {
            emit(Response.Failure(e.localizedMessage ?: "An error occurred"))
        }
    }
}