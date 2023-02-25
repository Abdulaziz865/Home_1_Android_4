package com.example.home_1_android_4.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

abstract class BaseFlowFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {

    abstract val navigationID : Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNavigation()
    }

    protected open fun setupNavigation() {
        val navHostFragment =
            childFragmentManager.findFragmentById(navigationID) as NavHostFragment
        val navController = navHostFragment.navController
    }
}