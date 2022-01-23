package com.example.fragment_kotlin_task5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.fragment_kotlin_task5.adapter.ViewPagerAdapter
import com.example.fragment_kotlin_task5.fragment.ContactFragment
import com.example.fragment_kotlin_task5.fragment.PostFragment
import com.example.fragment_kotlin_task5.fragment.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        val navigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val viewPagerAdapter = ViewPagerAdapter(initFragments(), supportFragmentManager)
        viewPager.adapter = viewPagerAdapter

        navigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.contact -> {
                    navigationView.setBackgroundColor(
                        ContextCompat.getColor(this, R.color.green_light)
                    )
                    viewPager.currentItem = 0
                }
                R.id.user -> {
                    navigationView.setBackgroundColor(
                        ContextCompat.getColor(
                            this,
                            R.color.blue_light
                        )
                    )
                    viewPager.currentItem = 1
                }
                R.id.posts -> {
                    navigationView.setBackgroundColor(
                        ContextCompat.getColor(
                            this,
                            R.color.red_light
                        )
                    )
                    viewPager.currentItem = 2
                }
            }
            true
        }

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                supportActionBar!!.title = when (position) {
                    0 -> "Contacts"
                    1 -> "Users"
                    2 -> "Posts"
                    else -> ""
                }
                navigationView.setBackgroundColor(
                    when (position) {
                        0 -> ContextCompat.getColor(this@MainActivity, R.color.green_light)
                        1 -> ContextCompat.getColor(this@MainActivity, R.color.blue_light)
                        2 -> ContextCompat.getColor(this@MainActivity, R.color.red_light)
                        else -> ContextCompat.getColor(this@MainActivity, R.color.green_light)
                    }
                )
            }

            override fun onPageSelected(position: Int) {
                navigationView.menu.getItem(position).isChecked = true
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    private fun initFragments(): ArrayList<Fragment> {
        return arrayListOf(
            ContactFragment(),
            UserFragment(),
            PostFragment()
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.light -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            R.id.dark -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        return super.onOptionsItemSelected(item)
    }
}