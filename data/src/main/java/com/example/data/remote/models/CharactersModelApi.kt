package com.example.data.remote.models

import com.google.gson.annotations.SerializedName

class CharactersModelApi {

    @SerializedName("code")
    val code: Int? = null
    @SerializedName("status")
    val status: String? = null
    @SerializedName("copyright")
    val copyright: String? = null
    @SerializedName("attributionText")
    val attributionText: String? = null
    @SerializedName("attributionHTML")
    val attributionHTML: String? = null
    @SerializedName("etag")
    val etag: String? = null
    @SerializedName("data")
    val data: Data? = null

    class Data {

        @SerializedName("offset")
        val offset: Int? = null
        @SerializedName("limit")
        val limit: Int? = null
        @SerializedName("total")
        val total: Int? = null
        @SerializedName("count")
        val count: Int? = null
        @SerializedName("results")
        val results: List<Result>? = null

        class Result {

            @SerializedName("id")
            val id: Int? = null
            @SerializedName("name")
            val name: String? = null
            @SerializedName("description")
            val description: String? = null
            @SerializedName("modified")
            val modified: String? = null
            @SerializedName("thumbnail")
            val thumbnail: Thumbnail? = null
            @SerializedName("resourceURI")
            val resourceURI: String? = null
            @SerializedName("comics")
            val comics: Comics? = null
            @SerializedName("series")
            val series: Series? = null
            @SerializedName("stories")
            val stories: Stories? = null
            @SerializedName("events")
            val events: Events? = null
            @SerializedName("urls")
            val urls: List<Url>? = null

            class Url {

                @SerializedName("type")
                val type: String? = null
                @SerializedName("url")
                val url: String? = null
            }

            class Thumbnail {

                @SerializedName("path")
                val path: String? = null
                @SerializedName("extension")
                val extension: String? = null
            }

            class Comics {

                @SerializedName("available")
                val available: Int? = null
                @SerializedName("collectionURI")
                val collectionURI: String? = null
                @SerializedName("items")
                val items: List<ItemComics>? = null
                @SerializedName("returned")
                val returned: Int? = null

                class ItemComics {

                    @SerializedName("resourceURI")
                    val resourceURI: String? = null
                    @SerializedName("name")
                    val name: String? = null
                }
            }

            class Series {

                @SerializedName("available")
                val available: Int? = null
                @SerializedName("collectionURI")
                val collectionURI: String? = null
                @SerializedName("items")
                val items: List<ItemSeries>? = null
                @SerializedName("returned")
                val returned: Int? = null

                class ItemSeries {

                    @SerializedName("resourceURI")
                    val resourceURI: String? = null
                    @SerializedName("name")
                    val name: String? = null
                }
            }

            class Stories {

                @SerializedName("available")
                val available: Int? = null
                @SerializedName("collectionURI")
                val collectionURI: String? = null
                @SerializedName("items")
                val items: List<ItemStories>? = null
                @SerializedName("returned")
                val returned: Int? = null

                class ItemStories {

                    @SerializedName("resourceURI")
                    val resourceURI: String? = null
                    @SerializedName("name")
                    val name: String? = null
                    @SerializedName("type")
                    val type: String? = null
                }
            }

            class Events {
                @SerializedName("available")
                val available: Int? = null
                @SerializedName("collectionURI")
                val collectionURI: String? = null
                @SerializedName("items")
                val items: List<ItemEvents>? = null
                @SerializedName("returned")
                val returned: Int? = null

                class ItemEvents {

                    @SerializedName("resourceURI")
                    val resourceURI: String? = null
                    @SerializedName("name")
                    val name: String? = null
                }
            }
        }
    }

}