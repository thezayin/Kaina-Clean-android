package com.thezayin.kainaclean.pricing.presentation.screen.state

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import com.thezayin.kainaclean.pricing.domain.model.DomesticServices

class DomesticDataState {
    var domestic = mutableStateListOf<DomesticServices>()
    fun itemSelected(domesticService: DomesticServices) {
        val iterator = domestic.listIterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            iterator.set(
                if (item.id == domesticService.id) {
                    domesticService
                } else {
                    item.copy(
                        isSelected = false
                    )
                }
            )
        }
    }

    fun setNewDomesticList(domesticServices: List<DomesticServices>) {
        this.domestic = domesticServices.toMutableStateList()
    }
}