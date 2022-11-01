package com.example.codialapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.codialapp.R
import com.example.codialapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.cardView2.setOnClickListener {

            findNavController().navigate(R.id.courseFragment)
        }

        binding.cardMentor.setOnClickListener {

            findNavController().navigate(R.id.mentorFragment)
        }

        binding.cardView3.setOnClickListener {
            findNavController().navigate(R.id.guruhFragment)
        }




        return binding.root
    }


}