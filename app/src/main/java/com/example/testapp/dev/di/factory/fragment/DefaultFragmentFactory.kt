package com.example.testapp.dev.di.factory.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.testapp.dev.di.annotation.ActivityScoped
import javax.inject.Inject
import javax.inject.Provider


@ActivityScoped
class DefaultFragmentFactory @Inject constructor(
    private val creators: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String, args: Bundle?): Fragment {
        val fragmentClass = loadFragmentClass(classLoader, className)
        val found = creators.entries.find { fragmentClass.isAssignableFrom(it.key) }
        val provider = found?.value
        //if we don't find a match in the map, proceed with the default empty constructor
        return if (provider != null) {
            provider.get().apply {
                arguments = args
            }
        } else {
            fragmentClass.newInstance().apply {
                arguments = args
            }
        }
    }
}