package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import timber.log.Timber

class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    lateinit var navController : NavController
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        navController = Navigation.findNavController(this,R.id.myNavHostFragment)
        toolbar = findViewById<Toolbar>(R.id.toolbar)

        setupActionBar()

        // Add Listeners
        navController.addOnDestinationChangedListener(this)
    }

    private fun setupActionBar() {
        // Set top level destinations
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.loginFragment,
            R.id.welcomeFragment, R.id.instructionsFragment,
            R.id.shoeListFragment, R.id.shoeDetailFragment))

        setSupportActionBar(toolbar)
        toolbar.setupWithNavController(navController,appBarConfiguration)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        setupActionBar()
    }
}
