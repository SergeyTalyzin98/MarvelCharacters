package sergeytalyzin.comicbooks.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.domain.repositiries.CharactersRepository
import kotlinx.coroutines.*
import sergeytalyzin.comicbooks.helpers.CharactersState

class CharactersViewModel {

    val state = MutableLiveData<CharactersState>()
    var queryText: String = ""
    private var waitNewData = false
    private lateinit var wait: Job

    private fun waitingNewData() = GlobalScope.launch {
        waitNewData = true
        delay(1000)
        getCharacters(name = queryText)
        waitNewData = false
    }

    fun setQuery(query: String) {

        if(query != "") {

            state.value = CharactersState.LoadingState()
            queryText = query

            if(waitNewData) {
                wait.cancel()
                wait = waitingNewData()
            }
            else
                wait = waitingNewData()
        }
        else {
            try {
                wait.cancel()
                state.value = CharactersState.DefaultState()
            }catch (e: Exception) {}
        }
    }

    private fun getCharacters(name: String) {

        val ts = System.currentTimeMillis().toString()

        GlobalScope.launch {
            val data = CharactersRepository().getCharactersByName(nameCharacter = name, ts = ts)
            launch(Dispatchers.Main) {

                if (data == null) state.value = CharactersState.ErrorState("Ошибка загрузки данных")
                else if (data.isEmpty()) state.value = CharactersState.ErrorState("Ничего не найдено")
                else state.value = CharactersState.LoadedState(data = data)
            }
        }
    }
}