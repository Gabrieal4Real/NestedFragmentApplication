package com.example.nestedfragmentinandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.nestedfragmentinandroid.levelFragment.LevelFragment
import com.example.nestedfragmentinandroid.levelFragment.OnHoldFragment
import com.google.android.material.tabs.TabLayout

class LevelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_level)
        addFragment()
    }

    private fun addFragment() {
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val adapter = LevelViewPagerAdapter(supportFragmentManager)
        for (level in 0..5) {
            if (level == 0) adapter.addFragment(OnHoldFragment(), "On Hold")
            else {
                adapter.addFragment(LevelFragment(level), "Level $level")
            }

        }
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}