package com.example.data.remote.services

import com.example.data.remote.models.CharactersModelApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicsService {


    @GET("comics")
    fun getComicsByQuery(@Query("ts") ts: String,
                         @Query("titleStartsWith") name: String,
                         @Query("apikey") key: String,
                         @Query("hash") hash: String): Call<CharactersModelApi>

    @GET("comics/{comicId}")
    fun getComicsById(@Query("ts") ts: String,
                      @Path("comicId") comicId: String,
                      @Query("apikey") key: String,
                      @Query("hash") hash: String): Call<CharactersModelApi>
}