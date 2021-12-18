package com.newera.dog_adoption

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.newera.dog_adoption.databinding.FragmentDogIntroBinding
import java.util.*
import kotlin.collections.ArrayList

class DogIntroFragment : Fragment(R.layout.fragment_dog_intro)
{
    private var _binding : FragmentDogIntroBinding? = null
    private val binding get() = _binding!!

    private lateinit var dogListAdapter : DogListAdapter
    private val dogList : MutableList<DogItem> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDogIntroBinding.bind(view)

        // Add initial data
        addInitialItem()

        // Initalize adapter
        dogListAdapter = DogListAdapter()
        binding.introRecyclerview.apply {
            adapter =  dogListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        dogListAdapter.submitList(dogList)

        // Set Search View
        binding.introSearchview.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener{

                override fun onQueryTextSubmit(query: String): Boolean {
                    Toast.makeText(requireContext(),"Request have been submitted",Toast.LENGTH_SHORT).show()
                    return false
                }

                override fun onQueryTextChange(query: String): Boolean {
                    val newlist = dogList.filter {
                        it.name.lowercase(Locale.getDefault()).contains(query)
                    }
                    dogListAdapter.submitList(newlist)

                    if (newlist.isEmpty())
                    {
                        Toast.makeText(requireContext(),"No match found",Toast.LENGTH_SHORT).show()
                    }
                    return false
                }
            })
        }

    }

    private fun addInitialItem()
    {
        dogList.clear()
        dogList.add(DogItem(id=1,name = "Andreas",age = 5))
        dogList.add(DogItem(id=2,name = "Maxime",age = 8))
        dogList.add(DogItem(id=3,name = "Dior",age = 7))
        dogList.add(DogItem(id=4,name = "Jack",age = 6))
        dogList.add(DogItem(id=5,name = "Peter"))
        dogList.add(DogItem(id=6,name = "Tom",age = 6))
        dogList.add(DogItem(id=7,name = "Jerry"))
        dogList.add(DogItem(id=8,name = "Batman",age = 2))
        dogList.add(DogItem(id=9,name = "Superman"))
        dogList.add(DogItem(id=10,name = "Spiderman",age = 7))
        dogList.add(DogItem(id=11,name = "Clair",age = 5))
        dogList.add(DogItem(id=12,name = "Anderson",age = 11))
        dogList.add(DogItem(id=13,name = "Frank",age = 12))
        dogList.add(DogItem(id=14,name = "Victor",age = 6))
    }

    override fun onDestroyView()
    {
        super.onDestroyView()
        _binding = null
    }
}