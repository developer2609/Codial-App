package com.example.codialapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.codialapp.OnItemClick
import com.example.codialapp.R
import com.example.codialapp.RvAdapter
import com.example.codialapp.adapter.GuruhAdapter
import com.example.codialapp.databinding.FragmentMentorBinding
import com.example.codialapp.databinding.ItemLayoutBinding
import com.example.codialapp.db.MyDbHelper2

import com.example.codialapp.models.Course
import com.example.codialapp.models.Mentor
import com.example.codialapp.models.MymentorObject

class MentorFragment : Fragment() ,OnItemClick{
    private lateinit var binding: FragmentMentorBinding
    private lateinit var rvAdapter: RvAdapter
    private lateinit var myDbHelper2: MyDbHelper2
    private lateinit var list: ArrayList<Course>
    private lateinit var course: Course
    private lateinit var mentorCousr: Course

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMentorBinding.inflate(layoutInflater)
        myDbHelper2 = MyDbHelper2(context)
        list = ArrayList()
        list.addAll(myDbHelper2.getAllCourse())
//        binding.rv.adapter = rvAdapter


        var itemLayoutBinding = ItemLayoutBinding.inflate(layoutInflater)







        rvAdapter = RvAdapter(list, object : OnItemClick {
            override fun onItemClicked(item: Course,position: Int) {
                Toast.makeText(context, "this", Toast.LENGTH_SHORT).show()
                findNavController().navigate(
                    R.id.action_mentorFragment_to_mentorAddFragment,
                    bundleOf("course" to item)
                )
            }
        })

        binding.rv.adapter = rvAdapter



        binding.chiqish2.setOnClickListener {
            findNavController().popBackStack()
        }









        return binding.root

    }

    override fun onItemClicked(item: Course, position: Int) {
        MymentorObject.courseId=position
        findNavController().navigate(R.id.mentorAddFragment, bundleOf("course" to course))
    }


}