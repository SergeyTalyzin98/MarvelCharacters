package sergeytalyzin.comicbooks.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.CharacterDomainModel
import com.squareup.picasso.Picasso
import sergeytalyzin.comicbooks.R
import sergeytalyzin.comicbooks.interfeces.AttachAdapterCharacters

class AdapterCharacters: RecyclerView.Adapter<AdapterCharacters.ViewHolder>() {

    private val characters = mutableListOf<CharacterDomainModel>()
    private lateinit var delegate: AttachAdapterCharacters

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)

        return ViewHolder(view, delegate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount() = characters.size

    fun attachDelegate(d: AttachAdapterCharacters) {
        delegate = d
    }

    fun setList(list: List<CharacterDomainModel>) {
        characters.clear()
        characters.addAll(list)
        notifyDataSetChanged()
    }

    fun clearList() = characters.clear()

    class ViewHolder(itemView: View, private val delegate: AttachAdapterCharacters?): RecyclerView.ViewHolder(itemView) {

        private val name = itemView.findViewById<TextView>(R.id.name_item)
        private val description = itemView.findViewById<TextView>(R.id.description_item)
        private val avatar = itemView.findViewById<ImageView>(R.id.avatar_item)
        private val wrapper = itemView.findViewById<CardView>(R.id.wrapper_item)

        fun bind(character: CharacterDomainModel) {
            name.text = character.name
            description.text = character.description
            Picasso.with(itemView.context).load(character.image100x100).into(avatar)

            wrapper.setOnClickListener {
                delegate?.onClick(character = character)
            }
        }
    }
}