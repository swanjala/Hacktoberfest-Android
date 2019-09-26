package com.naman14.hacktoberfest.dependencies

import com.naman14.hacktoberfest.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
class NetworkModule{
    @Provides
    @Singleton
    internal fun provideOKHttpInterceptor():  HttpLoggingInterceptor{
        return HttpLoggingInterceptor()
                .setLevel(if(BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
                else
                HttpLoggingInterceptor.Level.NONE)
    }
}