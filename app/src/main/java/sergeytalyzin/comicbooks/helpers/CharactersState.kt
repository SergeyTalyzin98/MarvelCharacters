package sergeytalyzin.comicbooks.helpers

import com.example.domain.models.CharacterDomainModel

sealed class CharactersState {
    class DefaultState: CharactersState()
    class LoadingState: CharactersState()
    class ErrorState<T>(val massage: T): CharactersState()
    class LoadedState(val data: List<CharacterDomainModel>): CharactersState()
}