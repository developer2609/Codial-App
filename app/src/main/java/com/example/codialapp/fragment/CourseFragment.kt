package com.example.codialapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.codialapp.OnItemClick
import com.example.codialapp.R
import com.example.codialapp.databinding.FragmentCourseBinding
import com.example.codialapp.databinding.ItemDialogBinding
import com.example.codialapp.databinding.ItemLayoutBinding
import com.example.codialapp.db.MyDbHelper2
import com.example.codialapp.models.Course

class CourseFragment : Fragment() {
    private lateinit var binding: FragmentCourseBinding
    private lateinit var myDbHelper2: MyDbHelper2
    private lateinit var rvAdapter: com.example.codialapp.RvAdapter
    private lateinit var list: ArrayList<Course>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCourseBinding.inflate(layoutInflater)

        myDbHelper2 = MyDbHelper2(context)
        list = ArrayList()
        list.addAll(myDbHelper2.getAllCourse())

        rvAdapter = com.example.codialapp.RvAdapter(list, object : OnItemClick {
            override fun onItemClicked(item: Course, position: Int) {
                findNavController().navigate(
                    R.id.action_courseFragment_to_aboutFragment,
                    bundleOf("course" to item)
                )
            }
        })
        binding.rv.adapter = rvAdapter




        binding.chiqish.setOnClickListener {

            Toast.makeText(context, "chiqish", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }

        binding.btnAdd.setOnClickListener {
            val dialog = AlertDialog.Builder(binding.root.context).create()
            val itemDialogBinding = ItemDialogBinding.inflate(layoutInflater)
            dialog.setView(itemDialogBinding.root)
            dialog.show()




            itemDialogBinding.buttonSave.setOnClickListener {
                val course = Course(
                    itemDialogBinding.edtName.text.toString().trim(),
                    itemDialogBinding.edtAbout.text.toString().trim()
                )
                myDbHelper2.addCourse(course)


                list.add(course)
                rvAdapter.notifyItemInserted(list.size - 1)
                Toast.makeText(context, "save", Toast.LENGTH_SHORT).show()
                dialog.cancel()


            }

        }


        var itemLayoutBinding = ItemLayoutBinding.inflate(layoutInflater)
        itemLayoutBinding.layoutOtish.setOnClickListener {
            Toast.makeText(context, "this", Toast.LENGTH_SHORT).show()
//            findNavController().navigate(R.id.aboutFragment)
        }




        return binding.root

    }


}