package sergeytalyzin.comicbooks.interfeces

import com.example.domain.models.CharacterDomainModel

interface AttachAdapterCharacters {
    fun onClick(character: CharacterDomainModel)
}