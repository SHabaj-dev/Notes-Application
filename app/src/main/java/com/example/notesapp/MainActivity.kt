package com.example.notesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.notesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Set up the bottom navigation
        binding.bottomNavigation.setupWithNavController(navController)

        // Set up the AppBarConfiguration
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navigation_home, R.id.navigation_settings)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Set up the FAB
        binding.fab.setOnClickListener {
            navController.navigate(R.id.action_home_to_edit)
        }

        // Handle navigation destination changes
        navController.addOnDestinationChangedListener { _, destination, _ ->
            // Show/hide FAB based on destination
            binding.fab.isVisible = destination.id == R.id.navigation_home
            
            // Set toolbar title based on destination
            when (destination.id) {
                R.id.navigation_home -> binding.toolbar.title = getString(R.string.app_name)
                R.id.navigation_settings -> binding.toolbar.title = getString(R.string.title_settings)
                R.id.navigation_edit_note -> binding.toolbar.title = getString(R.string.title_edit_note)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
} 