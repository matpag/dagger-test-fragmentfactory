package com.example.testapp.dev.di

import com.example.testapp.dev.MainActivity
import com.example.testapp.dev.di.annotation.ActivityScoped
import com.example.testapp.dev.di.factory.fragment.FragmentFactoryModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            FragmentFactoryModule::class
        ]
    )
    internal abstract fun mainActivity(): MainActivity

}