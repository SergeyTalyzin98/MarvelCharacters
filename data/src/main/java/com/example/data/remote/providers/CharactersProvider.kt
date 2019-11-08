package com.example.data.remote.providers

import com.example.data.remote.Data
import com.example.data.remote.RetrofitFactory
import com.example.data.remote.getMd5
import com.example.data.remote.models.CharactersModelApi
import retrofit2.await

class CharactersProvider {

    companion object {

       suspend fun getCharacters(ts: String, nameCharacter: String) : CharactersModelApi? {

           try {
               return RetrofitFactory.getCharactersService().getCharactersByQuery(
                   ts = ts, name = nameCharacter, key = Data.PublicApiKey.title, hash = getMd5(ts)
               ).await()
           }catch (e: Exception) {

                return null
           }
       }
    }
}
