package com.example.testapp.dev.ui.navigation

import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.plusAssign

/**
 * Temporary work-around to let navigation component consider our fragment factory
 * https://issuetracker.google.com/issues/119054429#comment4
 */
class MyNavHostFragment : NavHostFragment() {
    override fun createFragmentNavigator(): Navigator<out FragmentNavigator.Destination> {
        val fragmentNavigator = MyFragmentNavigator(requireContext(), childFragmentManager, id)
        navController.navigatorProvider += fragmentNavigator
        navController.navigatorProvider += MyDialogFragmentNavigator(childFragmentManager)
        return fragmentNavigator
    }
}