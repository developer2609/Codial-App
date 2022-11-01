package com.example.codialapp.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.codialapp.fragment.ViewPagerFragment1
import com.example.codialapp.fragment.ViewPagerFragment2

class MyPagerAdapter(fragment: Fragment):FragmentStateAdapter(fragment) {
      override fun getItemCount(): Int =2

       override fun createFragment(position: Int): Fragment {

         return when(position){
     0->ViewPagerFragment1()


          else ->ViewPagerFragment2()

         }
    }


}