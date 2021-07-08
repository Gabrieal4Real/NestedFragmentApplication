package com.example.nestedfragmentinandroid.levelFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.nestedfragmentinandroid.CustomViewPager
import com.example.nestedfragmentinandroid.LevelViewPagerAdapter
import com.example.nestedfragmentinandroid.LevelsRulesAdapter
import com.example.nestedfragmentinandroid.R
import com.google.android.material.tabs.TabLayout

class LevelFragment(i: Int) : Fragment() {
    private val level: Int = i
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_level, container, false)
        addFragment(view)
        return view
    }

    private fun addFragment(view: View) {
        val tabLayout: TabLayout = view.findViewById(R.id.tabLayout2)
        val viewPager: CustomViewPager = view.findViewById(R.id.viewPager2)
        viewPager.setPagingEnabled(false)
        val adapter = LevelViewPagerAdapter(childFragmentManager)
        adapter.addFragment(SubLevelFragment(getString(R.string.Rules)), getString(R.string.Rules))
        adapter.addFragment(SubLevelFragment(getString(R.string.Benefit)), getString(R.string.Benefit))
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}


class LevelOnHoldFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_level_on_hold, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = LevelsRulesAdapter(1234)

        //recyclerView.layoutManager = CustomGridLayoutManager(view.context)
        return view
    }

    class CustomGridLayoutManager(context: Context?) : LinearLayoutManager(context) {
        private var isScrollEnabled = false
        override fun canScrollVertically(): Boolean {
            return isScrollEnabled && super.canScrollVertically()
        }
    }
}
