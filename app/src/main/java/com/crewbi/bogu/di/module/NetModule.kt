package com.crewbi.bogu.di.module

import com.crewbi.bogu.BuildConfig
import com.crewbi.bogu.Constant
import com.crewbi.bogu.domain.net.service.BoguService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by baleen37@gmail.com on 14/09/2017.
 */
@Module
class NetModule {

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient {

        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        okHttpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
        okHttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.addInterceptor(logger)
        }

        return okHttpClientBuilder.build()

    }

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return GsonBuilder()
//                .registerTypeAdapter(Date::class.java, DateTypeDeserializer())
                .create()
    }

    @Provides
    @Singleton
    fun providesRetrofitBuilder(client: OkHttpClient, gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun providesBoguService(builder: Retrofit.Builder): BoguService {
        return builder.baseUrl(Constant.URL.BOGU_API_URL)
                .build()
                .create(BoguService::class.java)
    }
}