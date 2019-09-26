package com.naman14.hacktoberfest.dependencies

import com.naman14.hacktoberfest.BuildConfig
import com.naman14.hacktoberfest.network.api.ApiInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule{
    @Provides
    @Singleton
    internal fun provideOKHttpInterceptor(authToken:String):  HttpLoggingInterceptor{
        return HttpLoggingInterceptor()
                .setLevel(if(BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
                else
                HttpLoggingInterceptor.Level.NONE)

    }

    @Provides
    @Singleton
    internal fun okHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
        return OkHttpClient().newBuilder()
                .addInterceptor(ApiInterceptor(""))
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(1000, TimeUnit.SECONDS)
                .build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofitClient(okHttpClient: OkHttpClient):Retrofit {
        return Retrofit.Builder()
                .baseUrl("")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory()
                .build()
    }
}