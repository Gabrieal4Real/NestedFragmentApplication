package com.example.nestedfragmentinandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.RecyclerView
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

    override fun getPageTitle(position: Int): CharSequence {
        return fragmentTitle[position]

    }
}

class LevelsRulesAdapter(private val rulesAmount: Int) : RecyclerView.Adapter<RecyclerViewHolder>() {
    override fun getItemViewType(position: Int): Int {
        return R.layout.ll_onhold_container
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.view.text = rulesAmount.toString()
    }

    override fun getItemCount(): Int {
        return rulesAmount
    }
}

class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val view: TextView = itemView.findViewById(R.id.onHoldRulesTV)
}