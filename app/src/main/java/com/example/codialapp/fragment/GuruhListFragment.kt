package com.example.codialapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.codialapp.OnItemClick
import com.example.codialapp.R
import com.example.codialapp.RvAdapter
import com.example.codialapp.adapter.MyPagerAdapter
import com.example.codialapp.adapter.StateAdapter
import com.example.codialapp.databinding.FragmentGuruhListBinding
import com.example.codialapp.db.MyDbHelper2
import com.example.codialapp.models.Course
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class GuruhListFragment : Fragment() {
     private lateinit var myPagerAdapter: MyPagerAdapter
    private lateinit var binding: FragmentGuruhListBinding
    private lateinit var list: ArrayList<String>
   private lateinit var myDbHelper2: MyDbHelper2
   private lateinit var course: Course
  private lateinit var rvAdapter: RvAdapter
  private lateinit var lists:ArrayList<Course>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentGuruhListBinding.inflate(layoutInflater)

//        course = arguments?.getSerializable("course " ) as Course

        binding.back.setOnClickListener {

            findNavController().popBackStack()
        }
        list= ArrayList()

        list.add("Ochilgan guruhlar")
        list.add("Ochilayotgan guruhlar")
          myPagerAdapter= MyPagerAdapter(this)


        myDbHelper2= MyDbHelper2(binding.root.context)
        binding.viewpager.adapter=myPagerAdapter


        TabLayoutMediator(binding.myTablayout,binding.viewpager){tab,position->

       tab.text=list[position]

        }.attach()


       binding.add.visibility=View.VISIBLE

//        rvAdapter= RvAdapter(lists,object :OnItemClick{
//            override fun onItemClicked(item: Course, position: Int) {
//                findNavController().navigate(R.id.action_guruhListFragment_to_guruhQoshishFragment,
//                    bundleOf("course" to item))
//            }
//        })


       binding.add.setOnClickListener {
          findNavController().navigate(R.id.guruhQoshishFragment)
        }

     binding.myTablayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
         override fun onTabSelected(tab: TabLayout.Tab?) {

             if (tab!!.position==1){
            binding.add.visibility=View.VISIBLE
             }else{
                 binding.add.visibility=View.INVISIBLE
             }

         }

         override fun onTabUnselected(tab: TabLayout.Tab?) {
         }

         override fun onTabReselected(tab: TabLayout.Tab?) {

         }

     })


       return  binding.root
    }

}