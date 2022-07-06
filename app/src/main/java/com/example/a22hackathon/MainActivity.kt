package com.example.a22hackathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(HomeFragment())
        bottomNav = findViewById(R.id.buv_main) as BottomNavigationView
        bottomNav.setOnNavigationItemReselectedListener {
            when(it.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.nav_book -> {
                    loadFragment(BookFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.nav_book_report -> {
                    loadFragment(BookReportFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.nav_calendar -> {
                    loadFragment(CalendarFragment())
                    return@setOnNavigationItemReselectedListener
                }

            }
        }


    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}