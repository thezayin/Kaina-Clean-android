package com.thezayin.kainaclean.pricing.data.di

import com.thezayin.kainaclean.pricing.data.repository.CommercialRepositoryImpl
import com.thezayin.kainaclean.pricing.data.repository.DomesticRepositoryImpl
import com.thezayin.kainaclean.pricing.data.repository.PropertyTypeRepositoryImpl
import com.thezayin.kainaclean.pricing.domain.repository.CommercialRepository
import com.thezayin.kainaclean.pricing.domain.repository.DomesticRepository
import com.thezayin.kainaclean.pricing.domain.repository.PropertyTypeRepository
import com.thezayin.kainaclean.pricing.domain.usecase.property.PropertiesCase
import com.thezayin.kainaclean.pricing.domain.usecase.property.PropertyUseCases
import com.thezayin.kainaclean.pricing.domain.usecase.serices.CommercialService
import com.thezayin.kainaclean.pricing.domain.usecase.serices.DomesticService
import com.thezayin.kainaclean.pricing.domain.usecase.serices.ServicesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object PricingModule {

    @Singleton
    @Provides
    fun providePropertyTypeRepository(): PropertyTypeRepository {
        return PropertyTypeRepositoryImpl()
    }

    @Singleton
    @Provides
    fun providePropertyUseCases(repository: PropertyTypeRepository) = PropertyUseCases(
        propertyCase = PropertiesCase(repository),
    )

    @Singleton
    @Provides
    fun provideDomesticRepository(): DomesticRepository {
        return DomesticRepositoryImpl()
    }

    @Singleton
    @Provides
    fun provideCommercialRepository(): CommercialRepository {
        return CommercialRepositoryImpl()
    }

    @Singleton
    @Provides
    fun provideServicesUseCases(
        domesticRepository: DomesticRepository,
        commercialRepository: CommercialRepository
    ) = ServicesUseCases(
        domesticService = DomesticService(domesticRepository),
        commercialService = CommercialService(commercialRepository)
    )
}
