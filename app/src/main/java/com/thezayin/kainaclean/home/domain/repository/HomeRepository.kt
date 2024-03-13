package com.thezayin.kainaclean.home.domain.repository

import com.thezayin.kainaclean.home.domain.model.Home
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getDrawerItems(): Flow<Response<List<Home>>>
}