package com.example.data.remote

import com.example.data.remote.services.CharactersService
import com.example.data.remote.services.ComicsService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    companion object {

        private fun getRetrofit() = Retrofit.Builder()
                .baseUrl(Data.Url.title)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        fun getCharactersService() = getRetrofit().create(CharactersService::class.java)

        fun getComicsService() = getRetrofit().create(ComicsService::class.java)
    }
}