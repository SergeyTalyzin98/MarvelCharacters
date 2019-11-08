package sergeytalyzin.comicbooks.interfeces

import com.example.domain.models.CharacterDomainModel

interface StatesCharactersView {
    fun startLoading()
    fun finishLoading()
    fun error(message: Int)
    fun error(message: String)
    fun setList(data: List<CharacterDomainModel>)
    fun default()
}