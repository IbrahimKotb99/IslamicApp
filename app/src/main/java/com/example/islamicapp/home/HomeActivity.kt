package com.example.islamicapp.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islamicapp.R
import com.example.islamicapp.databinding.ActivityHomeBinding
import com.example.islamicapp.home.tabs.HadethFragment
import com.example.islamicapp.home.tabs.quran.QuranFragment
import com.example.islamicapp.home.tabs.RadioFragment
import com.example.islamicapp.home.tabs.TasbehFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.islamicBottomNavigation.selectedItemId = R.id.navigation_quran
        showFragment(QuranFragment())
        binding.islamicBottomNavigation.setOnItemSelectedListener { menuitem ->
            var fragment: Fragment = when (menuitem.itemId) {

                R.id.navigation_quran -> QuranFragment()

                R.id.navigation_hadeth -> HadethFragment()

                R.id.navigation_radio -> RadioFragment()

                R.id.navigation_tasbeh -> TasbehFragment()

                else -> QuranFragment()
            }

            showFragment(fragment)
            return@setOnItemSelectedListener true
        }

    }

    fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.islamic_fragment_contaner, fragment)
            .commit()
    }
}