package com.thezayin.kainaclean.estimate.data.repository

import android.annotation.SuppressLint
import com.google.firebase.firestore.FirebaseFirestore
import com.thezayin.kainaclean.estimate.domain.model.Estimate
import com.thezayin.kainaclean.estimate.domain.repository.RequestEstimateRepository
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject

class RequestEstimateRepositoryImpl @Inject constructor(val fireStore: FirebaseFirestore) :
    RequestEstimateRepository {
    private var operationSuccessFull = false

    @SuppressLint("SimpleDateFormat")
    val sdf = SimpleDateFormat("dd/M/yyyy")
    private val currentDate: String = sdf.format(Date())

    override fun addEstimateToFirebase(
        userId: String,
        address: String,
        date: String,
        service: String,
        propertyType: String,
    ): Flow<Response<Boolean>> = flow {
        operationSuccessFull = false
        try {
            val estimateId = fireStore.collection("requested_estimated").document().id
            val estimate = Estimate(
                userId = userId,
                estimateId = estimateId,
                address = address,
                date = date,
                serviceRequired = service,
                addedDate = currentDate,
                propertyType = propertyType,
                status = false
            )
            fireStore.collection("requested_estimates").document(estimateId).set(estimate)
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