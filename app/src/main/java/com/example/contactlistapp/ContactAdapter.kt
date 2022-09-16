package com.example.contactlistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contact_item.view.*

class ContactAdapter(var listener: ClickItemContactListener) : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    private val list: MutableList<Contact> = mutableListOf()

    //Cria cada Item da Lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view, list, listener)
    }

    //Faz a Leitura do Item do Array e Popula na Tela
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    //Quantidade de Itens que a Lista Possui
    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(list: List<Contact>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    //Responsável por Fazer o Binding de Cada Item da Lista
    inner class ContactAdapterViewHolder(itemView: View, var list: List<Contact>, var listener: ClickItemContactListener) :
        RecyclerView.ViewHolder(itemView){

        private val tvName: TextView = itemView.textViewName
        private val tvPhone: TextView = itemView.textViewPhone
        private val ivPhoto: ImageView = itemView.imageViewPhoto

        //Criando o Click:
        init {
            itemView.setOnClickListener {
                listener.clickItemContact(list[adapterPosition])
            }
        }

        fun bind(contact: Contact){

            tvName.text = contact.name
            tvPhone.text = contact.phone
            ivPhoto.setImageResource(R.drawable.padrao)

        }

    }

}


//Anotações:
/*
    A classe Adapter faz o gerenciamento da lista
    A classe View Holder faz o gerenciamento de cada item da lista
*/