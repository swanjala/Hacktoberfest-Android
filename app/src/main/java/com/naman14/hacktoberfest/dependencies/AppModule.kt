package com.naman14.hacktoberfest.dependencies

import android.app.Application
import android.content.Context
import com.naman14.hacktoberfest.network.api.services.SearchService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class AppModule( private val application: Application){
    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideNetworkService(retrofit: Retrofit): SearchService{
        return retrofit.create(SearchService::class.java)
    }

}