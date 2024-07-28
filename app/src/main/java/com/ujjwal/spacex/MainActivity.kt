package com.ujjwal.spacex

import android.app.UiModeManager
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.ujjwal.spacex.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {

        //set dark mode according to settings
        val uiManager: UiModeManager = this.getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
        uiManager.nightMode= UiModeManager.MODE_NIGHT_YES

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
        setBottomNavigation()
    }




    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragmentMainActivity)
        navController = navHostFragment?.findNavController()!!
        NavigationUI.setupWithNavController(
            binding.mainBottomNavigation,
            navController
        )

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.homeFragment || destination.id == R.id.searchFragment || destination.id == R.id.storeFragment ) {
                binding.mainBottomNavigation.visibility = View.VISIBLE
            } else {
                binding.mainBottomNavigation.visibility = View.GONE
            }
        }
    }

    private fun setBottomNavigation() {
        binding.mainBottomNavigation.setOnItemSelectedListener { item ->
            if (item.itemId != binding.mainBottomNavigation.selectedItemId) { }
            NavigationUI.onNavDestinationSelected(item, navController)
            when (item.itemId) {
                R.id.homeFragment -> {
                    navController.navigate(R.id.homeFragment)
                    Timber.d("HomeFragment from bottom navigation")
                }
                R.id.searchFragment -> {
                    navController.navigate(R.id.searchFragment)
                    Timber.d("SearchFragment from bottom navigation")
                }
                R.id.storeFragment -> {
                    navController.navigate(R.id.storeFragment)
                    Timber.d("StoreFragment from bottom navigation")
                }
                else -> {
                    item.isChecked = false
                }
            }
            true
        }
    }

}