package com.example.atividaderecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PokemonAdapter(
    private val pokemons: List<Pokemon>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val imageView: ImageView = itemView.findViewById(R.id.imageViewPokemon)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewType: TextView = itemView.findViewById(R.id.textViewType)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val currentItem = pokemons[position]
        holder.imageView.setImageResource(currentItem.imageResId)
        holder.textViewName.text = currentItem.name
        holder.textViewType.text = currentItem.type
    }

    override fun getItemCount() = pokemons.size

    fun getItem(position: Int) = pokemons[position]
}
