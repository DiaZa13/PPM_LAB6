package com.example.ppm_4.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.ppm_4.R
import com.example.ppm_4.databinding.ActivityMainBinding
import com.example.ppm_4.models.Guest
import com.example.ppm_4.models.Guests

class MainActivity() : AppCompatActivity() , Guests {

    private lateinit var drawerLayout: DrawerLayout
    override var guests: ArrayList<Guest> = arrayListOf(
        Guest("María Mireya Manríquez Acevedo","1234-5678","mariamanriquez@gmail.com",""),
        Guest("Ofelia Marcela Aguilar Lemus","3595-6596","ofelialemus12@hotmail.com"," "),
        Guest("Francisco Eduardo López Alarcón","3575-9845","francisalarcon@hotmail.com", " "),
        Guest("José Israel Camacho porras","4859-3324","israelcamacho@gmail.com"," ")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        drawerLayout = binding.drawerLayout
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)

        NavigationUI.setupWithNavController(binding.navView, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController,drawerLayout)
    }

}
