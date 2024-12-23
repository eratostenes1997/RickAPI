package com.example.rickapi.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickapi.databinding.ItemCharacterBinding
import com.example.rickapi.model.Character

class CharacterAdapter(private var list: List<Character>):RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(val binding: ItemCharacterBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding= ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val currentCharacter = list[position]

        holder.binding.tvNameCharacter.text = currentCharacter.name

        Glide.with(holder.binding.imgCharacter.context)
            .load(currentCharacter.imageUrl)
            .into(holder.binding.imgCharacter)
    }

    fun updateListCharacters(newCharacters: List<Character>){
        list = newCharacters
        notifyDataSetChanged()
    }


}