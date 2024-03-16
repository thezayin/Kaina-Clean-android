package com.thezayin.kainaclean.estimate_history.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.thezayin.kainaclean.estimate_history.domain.model.EstimateHistory
import com.thezayin.kainaclean.estimate_history.domain.repository.EstimateHistoryRepository
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class EstimateHistoryRepositoryImpl @Inject constructor(val fireStore: FirebaseFirestore) :
    EstimateHistoryRepository {
    override fun getMyEstimateFromFireStore(userId: String): Flow<Response<List<EstimateHistory>>> =
        callbackFlow {
            Response.Loading
            val snapshotListener =
                fireStore.collection("requested_estimates").whereEqualTo("userId", userId)
                    .addSnapshotListener { snapShot, error ->
                        val response = if (snapShot != null) {
                            val estimate = snapShot.toObjects(EstimateHistory::class.java)
                            Response.Success<List<EstimateHistory>>(estimate)
                        } else {
                            Response.Failure(error?.message ?: error.toString())
                        }
                        trySend(response).isSuccess
                    }
            awaitClose { snapshotListener.remove() }
        }

    override fun getCurrentEstimateFromFireStore(estimateId: String): Flow<Response<EstimateHistory>> =
        callbackFlow {
            Response.Loading
            val snapshotListener = fireStore.collection("requested_estimates").document(estimateId)
                .addSnapshotListener { snapShot, error ->
                    val response = if (snapShot != null) {
                        val estimate = snapShot.toObject<EstimateHistory>()
                        if (estimate != null) {
                            Response.Success(estimate)
                        } else {
                            Response.Failure("No Data found")
                        }
                    } else {
                        Response.Failure(error?.message ?: error.toString())
                    }
                    trySend(response).isSuccess
                }
            awaitClose { snapshotListener.remove() }
        }
}