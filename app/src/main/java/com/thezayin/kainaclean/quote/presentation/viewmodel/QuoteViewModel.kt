//package com.thezayin.kainaclean.presentation.quote
//
//import androidx.compose.runtime.State
//import androidx.compose.runtime.mutableStateOf
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.thezayin.kainaclean.domain.model.Quote
//import com.thezayin.kainaclean.auth.domain.usecases.AuthenticationUseCases
//import com.thezayin.kainaclean.presentation.booking.domain.usecase.BookingUseCases
//import com.thezayin.kainaclean.util.Response
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class QuoteViewModel @Inject constructor(
//    private val useCases: BookingUseCases,
//    private val authUseCases: AuthenticationUseCases
//) : ViewModel() {
//    private val _quoteData = mutableStateOf<Response<List<Quote>>>(Response.Loading)
//    val quoteData: State<Response<List<Quote>>> = _quoteData
//
//    private val _sendQuote = mutableStateOf<Response<Boolean>>(Response.Success(false))
//    val sendQuote: State<Response<Boolean>> = _sendQuote
//
//
//    fun sendQuote(
//        name: String,
//        email: String,
//        contact: String,
//        address: String,
//        city: String,
//        postCode: String,
//        propertyType: String,
//        service: String,
//        date: String,
//    ) {
//        viewModelScope.launch {
//            useCases.addQuoteUseCase(
//                userId = authUseCases.getCurrentUser.invoke(),
//                name = name,
//                email = email,
//                contact = contact,
//                address = address,
//                city = city,
//                postCode = postCode,
//                propertyType = propertyType,
//                service = service,
//                date = date,
//            ).collect {
//                _sendQuote.value = it
//            }
//        }
//    }
//}
//