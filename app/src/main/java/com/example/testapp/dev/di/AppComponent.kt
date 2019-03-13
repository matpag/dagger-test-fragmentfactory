package com.example.testapp.dev.di

import com.example.testapp.dev.AppApplication
import com.example.testapp.dev.di.factory.viewmodel.ViewModelFactoryModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Suppress("unused")
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBindingModule::class,
        ViewModelFactoryModule::class
    ]
)
interface AppComponent : AndroidInjector<AppApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<AppApplication>()
}