package com.example.nestedfragmentinandroid

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.*

class LevelViewPagerAdapter : FragmentPagerAdapter {
    private val fragmentArrayList = ArrayList<Fragment>()
    private val fragmentTitle = ArrayList<String>()

    constructor(fm: FragmentManager) : super(fm) {}
    constructor(fm: FragmentManager, behavior: Int) : super(fm, behavior) {}

    override fun getItem(position: Int): Fragment {
        return fragmentArrayList[position]
    }

    override fun getCount(): Int {
        return fragmentArrayList.size
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragmentArrayList.add(fragment)
        fragmentTitle.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitle[position]
    }
}