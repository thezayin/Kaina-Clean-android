package com.thezayin.kainaclean.home.data.repository

import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.home.domain.model.Home
import com.thezayin.kainaclean.home.domain.repository.HomeRepository
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor() : HomeRepository {
    override fun getDrawerItems(): Flow<Response<List<Home>>> = flow {
        try {
            emit(Response.Loading)
            val list = listOf(
                Home(icon = R.drawable.ic_price, title = "Pricing"),
                Home(icon = R.drawable.ic_stuf, title = "Services"),
                Home(icon = R.drawable.ic_quote, title = "Request Quote"),
                Home(icon = R.drawable.ic_estimate, title = "Request Estimate"),
                Home(icon = R.drawable.ic_bulltet, title = "Quote History"),
                Home(icon = R.drawable.ic_list, title = "Estimate History"),
            )
            emit(Response.Success(list))
        } catch (e: Exception) {
            emit(Response.Failure(e.localizedMessage ?: "Unexpected Error"))

        }
    }
}