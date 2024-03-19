package com.thezayin.kainaclean.pricing.presentation.screen.state

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import com.thezayin.kainaclean.pricing.domain.model.PropertyType

class PropertyDataState {
    var property = mutableStateListOf<PropertyType>()
    fun itemSelected(propertyType: PropertyType) {
        val iterator = property.listIterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            iterator.set(
                if (item.id == propertyType.id) {
                    propertyType
                } else {
                    item.copy(
                        isSelected = false
                    )
                }
            )
        }
    }

    fun setNewPropertyList(propertyType: List<PropertyType>) {
        this.property = propertyType.toMutableStateList()
    }
}