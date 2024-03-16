package com.thezayin.kainaclean.home.domain.usecases

import com.thezayin.kainaclean.home.domain.repository.HomeRepository

class HomeItem(
    private val repo: HomeRepository
) {
    operator fun invoke() = repo.getDrawerItems()
}