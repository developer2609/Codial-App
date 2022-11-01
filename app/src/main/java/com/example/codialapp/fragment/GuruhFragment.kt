package com.example.codialapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.graphics.createBitmap
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.codialapp.OnItemClick
import com.example.codialapp.R
import com.example.codialapp.RvAdapter
import com.example.codialapp.databinding.FragmentGuruhBinding
import com.example.codialapp.databinding.FragmentHomeBinding
import com.example.codialapp.db.MyDbHelper2
import com.example.codialapp.models.Course

class GuruhFragment : Fragment() {
    private lateinit var binding: FragmentGuruhBinding
    private lateinit var rvAdapter: RvAdapter
    private lateinit var list: ArrayList<Course>
    private lateinit var myDbHelper2: MyDbHelper2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding=FragmentGuruhBinding.inflate(layoutInflater)

        binding.chiqish3.setOnClickListener {
            findNavController().popBackStack()
        }


        myDbHelper2 = MyDbHelper2(context)
        list = ArrayList()
        list.addAll(myDbHelper2.getAllCourse())
//

             rvAdapter = RvAdapter(list, object : OnItemClick {
            override fun onItemClicked(item: Course, position: Int) {
                findNavController().navigate(
                    R.id.action_guruhFragment_to_guruhListFragment,
                    bundleOf("course" to item)
                )
            }
        })

        binding.rvGuruh.adapter = rvAdapter

        return binding.root
    }


}