package com.newera.dog_adoption

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.newera.dog_adoption.databinding.FragmentDogDetailBinding

class DogDetailFragment : Fragment(R.layout.fragment_dog_detail)
{
    private var _binding : FragmentDogDetailBinding? = null
    private val binding get() = _binding !!

    private val dogDetailFragmentArgs : DogDetailFragmentArgs by navArgs()

    private lateinit var curDog : DogItem

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        _binding = FragmentDogDetailBinding.bind(view)

        curDog = dogDetailFragmentArgs.dogItem

        binding.apply {
            nameTextview.text = "Name : ${curDog.name}"
            ageTextview.text = "Age : ${curDog.age}"
            introTextview.text = "Intro : ${curDog.description}"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}