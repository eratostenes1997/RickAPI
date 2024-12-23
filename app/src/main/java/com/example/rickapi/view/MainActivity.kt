package com.example.rickapi.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickapi.R
import com.example.rickapi.databinding.ActivityMainBinding
import com.example.rickapi.viewmodel.CharacterViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterListCharacter : CharacterAdapter
    private val characterViewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapterListCharacter = CharacterAdapter(emptyList())
        binding.rvCharacters.layoutManager = LinearLayoutManager(this)
        binding.rvCharacters.adapter = adapterListCharacter

        characterViewModel.characterListLive.observe(this){newList->
            adapterListCharacter.updateListCharacters(newList)
        }

        characterViewModel.loadCharacters()

    }
}