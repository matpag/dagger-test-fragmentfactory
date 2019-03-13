package com.example.testapp.dev.ui.navigation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator

/**
 * Temporary work-around to let navigation component consider our fragment factory
 * https://issuetracker.google.com/issues/119054429#comment4
 */
@Navigator.Name("fragment")
class MyFragmentNavigator(
    context: Context,
    fragmentManager: FragmentManager,
    fragmentContainer: Int
) : FragmentNavigator(context, fragmentManager, fragmentContainer) {
    override fun instantiateFragment(context: Context, fragmentManager: FragmentManager,
                                     className: String, args: Bundle?): Fragment {
        val clazz = Class.forName(className)
        return fragmentManager.fragmentFactory.instantiate(clazz.classLoader!!, className, args)
    }
}
