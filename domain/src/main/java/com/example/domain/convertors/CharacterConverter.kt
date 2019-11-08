package com.example.domain.convertors

import com.example.data.remote.models.CharactersModelApi
import com.example.domain.models.CharacterDomainModel

class CharacterConverter {

    companion object {

        fun convertFromApiToDomain(data: CharactersModelApi) : List<CharacterDomainModel>? {

            val comics = mutableListOf<CharacterDomainModel.Comics>()
            val listCharacters = mutableListOf<CharacterDomainModel>()

            data.data?.results?.forEach { character ->
                val name = character.name

                val description: String? = if(character.description == "")
                    "No description :("
                else
                    character.description

                var image100x100: String? = null
                var image270x200: String? = null
                character.thumbnail?.let { img ->
                    image100x100 = "${img.path}/standard_medium.${img.extension}"
                    image270x200 = "${img.path}/landscape_xlarge.${img.extension}"
                }

                character.comics?.items?.forEach {
                    comics.add(CharacterDomainModel.Comics(name = it.name!!, resourceURI = it.resourceURI!!))
                }

                listCharacters.add(CharacterDomainModel(name = name!!,
                    description = description!!, image100x100 = image100x100,
                    image270x200 = image270x200, comics = comics))
            }

            return listCharacters
        }
    }
}