package com.example.rickapi.repository

import com.example.rickapi.model.Character
import com.example.rickapi.net.RetrofitClient

class CharacterRepository {

    val api = RetrofitClient.api

    suspend fun fetchAllCharacters():List<Character>{
        return api.getAllCharacters().results
    }

}