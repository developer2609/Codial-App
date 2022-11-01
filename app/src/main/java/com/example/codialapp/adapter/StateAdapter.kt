package com.example.codialapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class StateAdapter(fm: FragmentManager, lifecycle: Lifecycle, val list: ArrayList<Fragment>):FragmentStateAdapter(fm,lifecycle) {

     val fragmentlist=list
    override fun getItemCount(): Int {

        return fragmentlist.size

    }

    override fun createFragment(position: Int): Fragment {

return  list[position]
    }
}