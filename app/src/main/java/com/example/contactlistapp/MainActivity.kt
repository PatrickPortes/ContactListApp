package com.example.contactlistapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.edit
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlistapp.ContactDetailActivity.Companion.EXTRA_CONTACT
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_drawer_menu.*

class MainActivity : AppCompatActivity(), ClickItemContactListener {

    private val rvList : RecyclerView by lazy { recyclerViewList }

    private val adapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.nav_drawer_menu)

        //supportActionBar!!.hide()

        initDrawer()
        fetchListContact()
        bindViews()
    }

    //Inicializando Drawer Layout
    private fun initDrawer(){

        val drawerLayout = drawerLayout as DrawerLayout
        val toolbar = toolbar
        setSupportActionBar(toolbar)

        //Toogle= Abrir e Fechar esse Layout
        val toogle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()
    }


    //Criação do Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true

    }

    //Listener do Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId){
            R.id.item_menu_1 -> {
                showToast("Option 1 Selecionada!!!")
                true
            }
            R.id.item_menu_2 -> {
                showToast("Option 2 Selecionada!!!")
                true
            }
            R.id.item_menu_3 -> {
                showToast("Option 3 Selecionada!!!")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


    //Recycler View:

    private fun bindViews(){
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)

        updateListData()
    }

    private fun updateListData(){
        val list = getListContacts()
        adapter.updateList(list)
    }

    //Convertendo uma String para um Objeto de Classe
    private fun getListContacts(): List<Contact>{

        val list = getInstanceSharedPreferences().getString("contacts", "[]")
        val turnsType = object : TypeToken<List<Contact>>(){}.type
        return Gson().fromJson(list, turnsType)

    }

    private fun fetchListContact(){

        var list = arrayListOf(
            Contact(
                "Patrick Portes",
                "(11) 01234-5678",
                "image.png",
            ),
            Contact(
                "Jose Almeida",
                "(11) 01234-5678",
                "image.png",
            ),
            Contact(
                "Caroline Fernandes",
                "(11) 01234-5678",
                "image.png",
            ),
            Contact(
                "Lucas Silva",
                "(11) 01234-5678",
                "image.png",
            ),
            Contact(
                "Matheus Augusto",
                "(11) 01234-5678",
                "image.png",
            ),
            Contact(
                "Amanda Pontes",
                "(11) 01234-5678",
                "image.png",
            ),
            Contact(
                "Charles Oliveira",
                "(11) 01234-5678",
                "image.png",
            ),
            Contact(
                "Thainá Vilela",
                "(11) 01234-5678",
                "image.png",
            ),
            Contact(
                "Renata Rodrigues",
                "(11) 01234-5678",
                "image.png",
            ),
            Contact(
                "Larissa Ferreira",
                "(11) 01234-5678",
                "image.png",
            )
        )
        getInstanceSharedPreferences().edit {
            val json = Gson().toJson(list)
            putString("contacts", json)
            //Garantindo o retorno da lista, salvando as mudanças (aplly() =assíncrona / commit()= síncrona
            commit()
        }
    }

    private fun getInstanceSharedPreferences(): SharedPreferences{
        return getSharedPreferences("com.example.contactlistaapp.PREFERENCES", Context.MODE_PRIVATE)
    }

    //Click Item Listener da Interface
    override fun clickItemContact(contact: Contact) {
        val intent = Intent(this, ContactDetailActivity::class.java)
        intent.putExtra(EXTRA_CONTACT, contact)
        startActivity(intent)
    }


}
