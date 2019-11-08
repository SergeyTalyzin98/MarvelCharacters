package sergeytalyzin.comicbooks.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.models.CharacterDomainModel
import kotlinx.android.synthetic.main.fragment_characters.*
import sergeytalyzin.comicbooks.R
import sergeytalyzin.comicbooks.activitys.CharacterDetailActivity
import sergeytalyzin.comicbooks.adapters.AdapterCharacters
import sergeytalyzin.comicbooks.helpers.CharactersState
import sergeytalyzin.comicbooks.helpers.Keys
import sergeytalyzin.comicbooks.interfeces.AttachAdapterCharacters
import sergeytalyzin.comicbooks.interfeces.StatesCharactersView
import sergeytalyzin.comicbooks.viewmodels.CharactersViewModel

class CharactersFragment : Fragment(), StatesCharactersView {

    interface CharactersFragmentListener {
        fun onFragmentInteraction(s: String)
    }

    //private var listener: CharactersFragmentListener? = null
    private var viewModel: CharactersViewModel? = CharactersViewModel()
    private var adapter: AdapterCharacters? = AdapterCharacters()

    override fun onAttach(context: Context) {
        super.onAttach(context)

//        if (context is CharactersFragmentListener)
//            listener = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        adapter?.attachDelegate(object : AttachAdapterCharacters {

            override fun onClick(character: CharacterDomainModel) {
                val intent = Intent(activity, CharacterDetailActivity::class.java)
                intent.putExtra(Keys.Character.title, character)
                startActivity(intent)
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)

        val searchItem = menu.findItem(R.id.search_menu)

        val searchView = MenuItemCompat.getActionView(searchItem) as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel?.setQuery(query = newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recycler_characters.layoutManager = LinearLayoutManager(activity)
        recycler_characters.adapter = adapter

        viewModel?.state?.observe(this@CharactersFragment,
            Observer<CharactersState> { newValue ->

                when(newValue) {
                    is CharactersState.DefaultState -> { default() }
                    is CharactersState.LoadingState -> { startLoading() }
                    is CharactersState.ErrorState<*> -> {
                        if(newValue.massage is Int) error(newValue.massage)
                        else error(newValue.massage as String)
                        default()
                    }
                    is CharactersState.LoadedState -> {
                        finishLoading()
                        setList(newValue.data)
                    }
                }
            })
    }

    override fun startLoading() {
        recycler_characters.visibility = View.GONE
        loading_characters.visibility = View.VISIBLE
        logo_characters.visibility = View.GONE
    }

    override fun finishLoading() {
        recycler_characters.visibility = View.VISIBLE
        loading_characters.visibility = View.GONE
        logo_characters.visibility = View.GONE
    }

    override fun error(message: Int) {
        Toast.makeText(activity, getString(message), Toast.LENGTH_SHORT).show()
    }

    override fun error(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun setList(data: List<CharacterDomainModel>) {
        adapter?.setList(list = data)
    }

    override fun default() {
        loading_characters.visibility = View.GONE
        recycler_characters.visibility = View.GONE
        logo_characters.visibility = View.VISIBLE
    }

//    private fun onButtonPressed(s: String) {
//        listener?.onFragmentInteraction(s)
//    }

    override fun onDetach() {
        super.onDetach()
        //listener = null
        adapter = null
        viewModel = null
    }
}
