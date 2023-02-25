package com.example.home_1_android_4.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.home_1_android_4.R
import com.example.home_1_android_4.data.locale.preference.userdata.UserPreferencesData
import com.example.home_1_android_4.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)

    @Inject
    lateinit var userPreferencesData: UserPreferencesData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        when {
            userPreferencesData.isAuthorized -> {
                navGraph.setStartDestination(R.id.homeFlowFragment)
            }
            else -> {
                navGraph.setStartDestination(R.id.signInFlowFragment)
            }
        }
        navController.graph = navGraph
    }
}
