package com.example.codialapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.codialapp.databinding.FragmentGuruhQoshishBinding
import com.example.codialapp.db.MyDbHelper2
import com.example.codialapp.models.Course
import com.example.codialapp.models.Guruh
import com.example.codialapp.models.Mentor
import com.example.codialapp.models.MymentorObject

class GuruhQoshishFragment : Fragment() {
    lateinit var binding: FragmentGuruhQoshishBinding
    var listday = ArrayList<String>()
    var listmentor = ArrayList<String>()
    var listtime = ArrayList<String>()
    lateinit var myDbHelper2: MyDbHelper2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGuruhQoshishBinding.inflate(layoutInflater)


        binding.toolbar.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.qaytish.setOnClickListener {
            findNavController().popBackStack()
        }


        myDbHelper2 = MyDbHelper2(binding.root.context)


        var list = myDbHelper2.getAllMentor()

        listmentor.add("scnsbjladb")

//        listmentor = myDbHelper2.getAllMentor().filter{
//            it.id == course.id
//        }.map {
//            "${it.name} ${it.surname}"
//        } as ArrayList<String> /* = java.util.ArrayList<kotlin.String> */


        binding.spinnerMentor.adapter =
            ArrayAdapter(binding.root.context, android.R.layout.simple_list_item_1, listmentor)


        listtime.add("10 : 00 - 12 : 00")
        listtime.add("12 : 00 - 14 : 00")
        listtime.add("14 : 00 - 16 : 00")
        listtime.add("16 : 00 - 18 : 00")
        listtime.add("18 : 00 - 20 : 00")



        binding.spinnerKursVaqti.adapter =
            ArrayAdapter(binding.root.context, android.R.layout.simple_list_item_1, listtime)


        listday.add("Dushanba/Chorshanba/Juma")
        listday.add("Seshanba/Payshanba/Shanba")


        binding.spinnerKunlari.adapter =
            ArrayAdapter(binding.root.context, android.R.layout.simple_list_item_1, listday)


        binding.saqlash.setOnClickListener {


            val guruhNomi = binding.edtGuruhNomi.text.toString()


            if (listmentor.isNotEmpty()) {


                val mentor = list[binding.spinnerMentor.selectedItemPosition]


                val time = listtime[binding.spinnerKursVaqti.selectedItemPosition]
                val days = listday[binding.spinnerKunlari.selectedItemPosition]
                MymentorObject.guruhnomi = guruhNomi
                MymentorObject.mentorspin = binding.spinnerMentor.selectedItemPosition
                MymentorObject.mentor = list as ArrayList<Mentor>
                MymentorObject.vaqtlar = binding.spinnerKursVaqti.selectedItemPosition
                MymentorObject.kunlar = days
                if (binding.edtGuruhNomi.text.isNotEmpty()) {

                    var group = Guruh(

                        guruhNomi,
                        mentor,
                        time,
                        days,
                        0,
                        MymentorObject.position
                    )
                    myDbHelper2.addGuruh(group)


                }

            } else {
                Toast.makeText(context, "Empty", Toast.LENGTH_SHORT).show()
            }

        }


        return binding.root
    }


}