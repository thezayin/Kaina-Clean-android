package com.thezayin.kainaclean.util

sealed class SortColumn(val displayName: String) {
    object Date : SortColumn("date")
    object Pending : SortColumn("pending")
    object Accepted : SortColumn("accepted")
}