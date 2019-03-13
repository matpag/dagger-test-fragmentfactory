package com.example.testapp.dev.di.factory.fragment

import androidx.fragment.app.FragmentFactory
import dagger.Binds
import dagger.Module


@Suppress("unused")
@Module
abstract class FragmentFactoryModule {

    @Binds
    internal abstract fun bindFragmentFactory(factory: DefaultFragmentFactory): FragmentFactory

}