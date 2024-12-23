package com.example.rickapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickapi.model.Character
import com.example.rickapi.repository.CharacterRepository
import kotlinx.coroutines.launch

class CharacterViewModel:ViewModel() {

    val characterListLive = MutableLiveData<List<Character>>()
    private val repository = CharacterRepository()

    fun loadCharacters(){
        viewModelScope.launch {
            try {
                characterListLive.value = repository.fetchAllCharacters()
            }catch (e:Exception){
                e.printStackTrace()
            }

        }
    }

}