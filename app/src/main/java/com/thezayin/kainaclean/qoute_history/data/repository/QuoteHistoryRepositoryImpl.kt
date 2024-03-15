package com.thezayin.kainaclean.qoute_history.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.thezayin.kainaclean.qoute_history.domain.model.QuoteHistory
import com.thezayin.kainaclean.qoute_history.domain.repository.QuoteHistoryRepository
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class QuoteHistoryRepositoryImpl @Inject constructor(val fireStore: FirebaseFirestore) :
    QuoteHistoryRepository {
    override fun getMyQuotesFromFireStore(userId: String): Flow<Response<List<QuoteHistory>>> =
        callbackFlow {
            Response.Loading
            val snapshotListener = fireStore.collection("quotes").whereEqualTo("userId", userId)
                .addSnapshotListener { snapShot, error ->
                    val response = if (snapShot != null) {
                        val quoteList = snapShot.toObjects(QuoteHistory::class.java)
                        Response.Success<List<QuoteHistory>>(quoteList)
                    } else {
                        Response.Failure(error?.message ?: error.toString())
                    }
                    trySend(response).isSuccess
                }
            awaitClose { snapshotListener.remove() }
        }

    override fun getCurrentQuoteFromFireStore(quoteId: String): Flow<Response<QuoteHistory>> =
        callbackFlow {
            Response.Loading
            val snapshotListener = fireStore.collection("quotes").document(quoteId)
                .addSnapshotListener { snapShot, error ->
                    val response = if (snapShot != null) {
                        val quote = snapShot.toObject<QuoteHistory>()
                        if (quote != null) {
                            Response.Success(quote)
                        } else {
                            Response.Failure("No Quote found")
                        }
                    } else {
                        Response.Failure(error?.message ?: error.toString())
                    }
                    trySend(response).isSuccess
                }
            awaitClose { snapshotListener.remove() }
        }
}