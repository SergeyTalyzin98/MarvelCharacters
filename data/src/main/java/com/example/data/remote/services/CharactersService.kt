package com.example.data.remote.services

import com.example.data.remote.models.CharactersModelApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersService {

    @GET("characters")
    fun getCharactersByQuery(@Query("ts") ts: String,
                      @Query("nameStartsWith") name: String,
                      @Query("apikey") key: String,
                      @Query("hash") hash: String): Call<CharactersModelApi>
}