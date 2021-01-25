package com.example.nestedfragmentinandroid.levelFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.nestedfragmentinandroid.R

class SubLevelFragment(private val title: String) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_sub_level, container, false)
        val tvLevelChild: TextView = view.findViewById(R.id.tvLevelChild)
        if (title == getString(R.string.Rules)) tvLevelChild.text = getString(R.string.Rules)
        if (title == getString(R.string.Benefit)) tvLevelChild.text = getString(R.string.Benefit)
        return view
    }
}