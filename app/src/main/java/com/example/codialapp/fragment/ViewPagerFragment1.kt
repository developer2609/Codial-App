package com.example.codialapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.codialapp.R
import com.example.codialapp.adapter.GuruhAdapter
import com.example.codialapp.adapter.RvClic
import com.example.codialapp.databinding.FragmentViewPagerBinding
import com.example.codialapp.db.MyDbHelper2
import com.example.codialapp.models.Guruh
import com.example.codialapp.models.MymentorObject

class ViewPagerFragment1 : Fragment() {
    lateinit var binding: FragmentViewPagerBinding
    lateinit var guruhAdapter: GuruhAdapter
    lateinit var myDbHelper2: MyDbHelper2
    lateinit var guruhlist: ArrayList<Guruh>
    lateinit var listMentor: ArrayList<String>
    lateinit var listVaqt: ArrayList<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentViewPagerBinding.inflate(layoutInflater)

        guruhlist = ArrayList()
        myDbHelper2 = MyDbHelper2(binding.root.context)
        listVaqt = ArrayList()
        listMentor = ArrayList()


//        for (i in myDbHelper2.getGuruh()){
//
//     if (i.open==1 && i.mycourse==MymentorObject.position){
//guruhlist.add(i)
//     }
//
//
//
//            guruhAdapter= GuruhAdapter(guruhlist,object :RvClic{
//                override fun showClik(guruh: Guruh, position: Int) {
//
//                    MymentorObject.position=position
//                    MymentorObject.close=1
//                    MymentorObject.group=guruh
//
////                    findNavController().navigate(R.id.)
//
//                }
//
//                override fun editclic(guruh: Guruh, position: Int) {
//                    TODO("Not yet implemented")
//                }
//
//                override fun deleteClic(guruh: Guruh, position: Int) {
//                    TODO("Not yet implemented")
//                }
//
//            })
//
//        }
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_view_pager1, container, false)
//    }

        return binding.root


    }
}