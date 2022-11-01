package com.example.codialapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.codialapp.R
import com.example.codialapp.adapter.MentorAdapter
import com.example.codialapp.databinding.FragmentMentorAddBinding
import com.example.codialapp.databinding.ItemDialog2Binding
import com.example.codialapp.databinding.ItemMentorBinding
import com.example.codialapp.db.MyDbHelper2
import com.example.codialapp.models.Course
import com.example.codialapp.models.Mentor
import com.example.codialapp.models.MymentorObject

class MentorAddFragment : Fragment(),MentorAdapter.MentorItemEvent {
    private lateinit var binding: FragmentMentorAddBinding
    private lateinit var mentorAdapter: MentorAdapter
    private lateinit var myDbHelper2: MyDbHelper2
    private lateinit var lists: ArrayList<Mentor>
    private lateinit var course: Course

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMentorAddBinding.inflate(layoutInflater)

        course = arguments?.getSerializable("course") as Course
        binding.courseName.text = course.name





        binding.chiqish.setOnClickListener {

            findNavController().popBackStack()
        }

        myDbHelper2 = MyDbHelper2(context)


        lists = ArrayList()
        lists.addAll(myDbHelper2.getAllMentor())
        mentorAdapter = MentorAdapter(lists,this)
        binding.rvAdd.adapter = mentorAdapter

        binding.btn.setOnClickListener {
            val dialog = AlertDialog.Builder(binding.root.context).create()
            val itemDialog2Binding = ItemDialog2Binding.inflate(layoutInflater)
            dialog.setView(itemDialog2Binding.root)

            itemDialog2Binding.btnSave.setOnClickListener {
                val mentor = Mentor(
                    itemDialog2Binding.textName.text.toString().trim(),
                    itemDialog2Binding.textSurane.text.toString().trim(),
                    itemDialog2Binding.textNumber.text.toString().trim(),
                    course
                )
                myDbHelper2.addMentor(mentor)



                lists.add(mentor)
                mentorAdapter.notifyItemInserted(lists.size - 1)
                Toast.makeText(context, "save", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            }

            dialog.show()

        }













        return binding.root
    }

    override fun editClic(mentor: Mentor, position: Int) {

        val dialog=AlertDialog.Builder(binding.root.context).create()
        val itemDialog2Binding=ItemDialog2Binding.inflate(layoutInflater)
           dialog.setView(itemDialog2Binding.root)
         itemDialog2Binding.btnSave.setOnClickListener {


               itemDialog2Binding.textName.setText(mentor.name)
               itemDialog2Binding.textSurane.setText(mentor.surname)
               itemDialog2Binding.textNumber.setText(mentor.number)

               mentor.name=itemDialog2Binding.textName.text.toString().trim()
               mentor.surname=itemDialog2Binding.textSurane.text.toString().trim()
               mentor.number=itemDialog2Binding.textNumber.text.toString().trim()
               myDbHelper2.editMentor(mentor)
               mentorAdapter.list=myDbHelper2.getAllMentor()
               Toast.makeText(context, "save", Toast.LENGTH_SHORT).show()

           }
        dialog.show()

    }

    override fun deleteClic(mentor: Mentor, position: Int) {


          myDbHelper2.deleteMentor(mentor)

           lists.remove(mentor)
        mentorAdapter.notifyDataSetChanged()
        Toast.makeText(context, "this", Toast.LENGTH_SHORT).show()

    }

}