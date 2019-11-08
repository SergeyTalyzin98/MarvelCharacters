package com.example.data.remote.providers

import com.example.data.remote.Data
import com.example.data.remote.RetrofitFactory
import com.example.data.remote.getMd5
import retrofit2.await

class ComicsProvider {

    companion object {

        suspend fun getComics(ts: String, titleStartsWith: String) : Any? {

            try {
                return RetrofitFactory.getComicsService().getComicsByQuery(
                    ts = ts, name = titleStartsWith, key = Data.PublicApiKey.title, hash = getMd5(ts)
                ).await()
            }catch (e: Exception) {

                return null
            }
        }

        suspend fun getComicById(ts: String, comicId: String) : Any? {

            try {
                return RetrofitFactory.getComicsService().getComicsById(
                    ts = ts, comicId = comicId, key = Data.PublicApiKey.title, hash = getMd5(ts)
                ).await()
            }catch (e: Exception) {

                return null
            }
        }
    }
}