package com.thezayin.kainaclean.pricing.presentation.screen.state

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import com.thezayin.kainaclean.pricing.domain.model.CommercialServices

class CommercialDataState {
    var commercial = mutableStateListOf<CommercialServices>()
    fun itemSelected(commercialServices: CommercialServices) {
        val iterator = commercial.listIterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            iterator.set(
                if (item.id == commercialServices.id) {
                    commercialServices
                } else {
                    item.copy(
                        isSelected = false
                    )
                }
            )
        }
    }

    fun setNewCommercialList(commercialServices: List<CommercialServices>) {
        this.commercial = commercialServices.toMutableStateList()
    }
}