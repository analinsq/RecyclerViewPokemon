package com.example.atividaderecyclerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), PokemonAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        recyclerView = findViewById(R.id.recyclerView)

        val pokemons = listOf(
            Pokemon("Bulbasaur", "Grama e Venenoso", R.drawable.bulbasaur),
            Pokemon("Charmander", "Fogo", R.drawable.charmander),
            Pokemon("Squirtle", "Água", R.drawable.squirtle),
            Pokemon("Gengar", "Fantasma e Venenoso", R.drawable.gengar),
            Pokemon("Meowth", "Normal", R.drawable.meowth),
            Pokemon("Pikachu", "Elétrico", R.drawable.pikachu),
            Pokemon("Psyduck", "Psíquico", R.drawable.psyduck),
            Pokemon("Rowlet", "Grama e Voador", R.drawable.rowlet),
            Pokemon("Mew", "Psíquico", R.drawable.mew),
            Pokemon("Oshawott", "Água", R.drawable.oshowott),
            Pokemon("Snorlax", "Normal", R.drawable.snorlax),
            Pokemon("Electabuzz", "Elétrico", R.drawable.electabuzz)
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokemonAdapter(pokemons, this)
    }

    override fun onItemClick(position: Int) {
        val pokemonName = (recyclerView.adapter as PokemonAdapter).getItem(position).name
        Toast.makeText(this, "Você clicou em $pokemonName", Toast.LENGTH_SHORT).show()
    }
}
