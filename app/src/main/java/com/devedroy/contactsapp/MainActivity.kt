package com.devedroy.contactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.devedroy.contactsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        navController = findNavController(R.id.navHostFragment)
        navController.navigate(R.id.contactsFragment)

        mainBinding.bottomNavView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_item_contact -> {
                    navController.navigate(R.id.action_contact)
                    true
                }

                R.id.menu_item_message -> {
                    navController.navigate(R.id.action_message)
                    true
                }

                else -> false
            }
        }
    }
}