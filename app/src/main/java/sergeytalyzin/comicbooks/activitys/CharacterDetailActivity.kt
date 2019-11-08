package sergeytalyzin.comicbooks.activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.models.CharacterDomainModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_character_detail.*
import sergeytalyzin.comicbooks.R
import sergeytalyzin.comicbooks.helpers.Keys

class CharacterDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)
        setSupportActionBar(toolbar_detail)
        val character = intent.getParcelableExtra<CharacterDomainModel>(Keys.Character.title)

        title = character.name
        name_detail.text = character.description
        Picasso.with(this@CharacterDetailActivity).load(character.image270x200).into(avatar_detail)
    }
}
