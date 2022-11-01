package com.example.codialapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codialapp.R
import com.example.codialapp.databinding.FragmentGuruhgaKirishBinding
import com.example.codialapp.db.MyDbHelper2

class GuruhgaKirishFragment : Fragment() {
    lateinit var binding: FragmentGuruhgaKirishBinding
    lateinit var myDbHelper2: MyDbHelper2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


         return inflater.inflate(R.layout.fragment_guruhga_kirish, container, false)
    }


}