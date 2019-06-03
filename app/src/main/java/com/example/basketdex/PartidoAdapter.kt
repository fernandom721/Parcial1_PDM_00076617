package com.example.basketdex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.basketdex.Database.Partido
import com.example.basketdex.Repository.PartidoRepository
import kotlinx.android.synthetic.main.list_element_partido.view.*
/*
class PartidoAdapter internal constructor(context: Context): RecyclerView.Adapter<PartidoAdapter.PartidoViewHolder>(){


    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var partidos = emptyList<Partido>()

    inner class PartidoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindPartido(partidos:Partido)= with(itemView){
            Glide.with(itemView.context)
            team1.text = partidos.teamA
            scorea.text = partidos.scoreA.toString()
            team2.text = partidos.teamB
            scorea.text = partidos.scoreB.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartidoViewHolder {
        val itemView = inflater.inflate(R.layout.list_element_partido,parent,false)
        return PartidoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PartidoViewHolder, position: Int) {
        holder.bindPartido(partidos[position])
    }

    override fun getItemCount()=partidos.size

}*/

class PartidoAdapter (var partidos:List<PartidoRepository>): RecyclerView.Adapter<PartidoAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartidoAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewer_element_partido,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return partidos.size
    }

    override fun onBindViewHolder(holder: PartidoAdapter.ViewHolder, position: Int) {
        holder.bind(partidos[position])
    }

    fun updateList(newPartido:List<PartidoRepository>){
        newPartido.forEach{
            println("jaja simon")
    }
        this.partidos = newPartido
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(partidos: PartidoRepository) = with(itemView){
            //this.team1.text = teama.name
        }
    }

}