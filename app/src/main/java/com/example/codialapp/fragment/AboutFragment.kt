package com.example.codialapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.codialapp.databinding.FragmentAboutBinding
import com.example.codialapp.databinding.ItemDialogBinding
import com.example.codialapp.databinding.ItemLayoutBinding
import com.example.codialapp.models.Course

class AboutFragment : Fragment() {
    private lateinit var binding: FragmentAboutBinding

    //    private lateinit var rvAdapter: RvAdapter
    private lateinit var list: ArrayList<Course>
    private lateinit var courseInfo: Course

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAboutBinding.inflate(layoutInflater)

        courseInfo = arguments?.getSerializable("course") as Course
        binding.textName.text = courseInfo.name
        binding.textAbout.text = courseInfo.about


//        myDbHelper = MyDbHelper(context)
//        list = ArrayList()
//        list.addAll(myDbHelper.getAllCourse())

//        rvAdapter=RvAdapter(list)
//        binding.rvAbout.adapter=rvAdapter

        var itemLayoutBinding = ItemLayoutBinding.inflate(layoutInflater)
        var itemDialogBinding = ItemDialogBinding.inflate(layoutInflater)
        itemLayoutBinding.btnOtish.setOnClickListener {

//         itemDialogBinding.edtName.text=aboutListBinding.textName.editableText
//            itemDialogBinding.edtAbout.text=aboutListBinding.textAbout.editableText


        }









        return binding.root
    }

}