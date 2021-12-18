package com.newera.dog_adoption

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.newera.dog_adoption.databinding.ItemDogBinding

val Comparator = object : DiffUtil.ItemCallback<DogItem>() {
    override fun areItemsTheSame(oldItem: DogItem,newItem: DogItem) : Boolean
    {
        return oldItem.id == newItem.id
    }
    override fun areContentsTheSame(oldItem: DogItem,newItem: DogItem) : Boolean
    {
        return oldItem == newItem
    }
}

class DogListAdapter() : ListAdapter<DogItem , DogListAdapter.ViewHolder>(Comparator)
{
    inner class ViewHolder(val binding: ItemDogBinding): RecyclerView.ViewHolder(binding.root)
    {
        fun bind(dogItem : DogItem)
        {
            binding.apply {
                dogNameTextview.text = "Name : ${dogItem.name}"
                dogAgeTextview.text = "Age : ${dogItem.age}"
                dogIntroTextview.text = "Intro : ${dogItem.description}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val binding = ItemDogBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val dogListViewHolder = ViewHolder(binding)

        binding.dogConstraint.setOnClickListener {
            val action = DogIntroFragmentDirections.actionDogIntroFragmentToDogDetailFragment(getItem(dogListViewHolder.adapterPosition))
            findNavController(parent).navigate(action)
        }

        return dogListViewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dogItem = getItem(position)
        holder.bind(dogItem)
    }

}