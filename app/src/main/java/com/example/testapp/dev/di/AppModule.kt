package com.example.testapp.dev.di

import android.content.Context
import com.example.testapp.dev.AppApplication
import dagger.Module
import dagger.Provides

@Suppress("unused")
@Module
class AppModule {

    @Provides
    fun provideContext(app: AppApplication): Context = app.applicationContext

}