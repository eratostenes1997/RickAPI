package com.example.rickapi.model

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("results")
    val results:List<Character>
)
