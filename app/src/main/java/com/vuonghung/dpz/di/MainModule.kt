package com.vuonghung.dpz.di

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.vuonghung.dpz.data.remote.ApiService
import com.vuonghung.dpz.presentation.adapter.ListUserAdapter
import com.vuonghung.dpz.utils.config.AppConst
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @BaseURL
    @Provides
    @Singleton
    fun provideBaseURL(): String = AppConst.BASE_URL

    @DevURL
    @Provides
    @Singleton
    fun provideDevUrl(): String = AppConst.DEV_URL

    @TestURL
    @Provides
    @Singleton
    fun provideTestUrl(): String = AppConst.TEST_URL

    @Provides
    fun provideOkHttpClient() = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, @BaseURL baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun providesSharedPreferences(@ActivityContext activity: Activity): SharedPreferences =
        activity.getSharedPreferences(AppConst.PREF_NAME, 0)

    //adapter
    @Provides
    @Singleton
    fun providesListUserAdapter(@ApplicationContext context: Context): ListUserAdapter =
        ListUserAdapter(
            context,
            arrayListOf()
        )
}