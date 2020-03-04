package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.models.MainViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    lateinit var navController : NavController
    lateinit var toolbar: Toolbar
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        navController = Navigation.findNavController(this,R.id.myNavHostFragment)
        toolbar = findViewById(R.id.toolbar)

        setupActionBar()

        // Add Listeners
        navController.addOnDestinationChangedListener(this)

        // Setup ViewModel
        Timber.i("Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
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
