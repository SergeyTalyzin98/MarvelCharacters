package com.example.domain.repositiries

import com.example.data.remote.providers.CharactersProvider
import com.example.domain.convertors.CharacterConverter
import com.example.domain.models.CharacterDomainModel

class CharactersRepository {

    suspend fun getCharactersByName(nameCharacter: String, ts: String) : List<CharacterDomainModel>? {

        val data = CharactersProvider.getCharacters(ts = ts, nameCharacter = nameCharacter)

        if (data == null) return null

        return CharacterConverter.convertFromApiToDomain(data = data)
    }
}