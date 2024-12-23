package com.example.rickapi.net

import com.example.rickapi.model.CharacterResponse
import retrofit2.http.GET

interface CharacterApiService {
    @GET("character")
    suspend fun getAllCharacters():CharacterResponse
}