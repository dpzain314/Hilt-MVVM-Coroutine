package com.vuonghung.dpz.di

import javax.inject.Qualifier

//Base URL
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DevURL

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class TestURL

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseURL

