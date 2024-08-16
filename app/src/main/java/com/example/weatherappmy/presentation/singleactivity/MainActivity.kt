package com.example.weatherappmy.presentation.singleactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherappmy.R
import com.example.weatherappmy.presentation.favorites.FavouritesCityFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main, FavouritesCityFragment.newInstance())
                .commit()
        }
    }
}