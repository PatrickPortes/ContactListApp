package com.example.contactlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_drawer_menu.*

class MainActivity : AppCompatActivity() {

    private val rvList : RecyclerView by lazy { recyclerViewList }

    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.nav_drawer_menu)

        //supportActionBar!!.hide()

        initDrawer()
        bindViews()
        updateListData()
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
    }

    private fun updateListData(){

        adapter.updateList(
            arrayListOf(
                Contact(
                    "Patrick Portes",
                    "(11) 01234-5678",
                    "image.png",
                ),
                Contact(
                    "Patrick Portes",
                    "(11) 01234-5678",
                    "image.png",
                ),
                Contact(
                    "Patrick Portes",
                    "(11) 01234-5678",
                    "image.png",
                ),
                Contact(
                    "Patrick Portes",
                    "(11) 01234-5678",
                    "image.png",
                ),
                Contact(
                    "Patrick Portes",
                    "(11) 01234-5678",
                    "image.png",
                ),
                Contact(
                    "Patrick Portes",
                    "(11) 01234-5678",
                    "image.png",
                ),
                Contact(
                    "Patrick Portes",
                    "(11) 01234-5678",
                    "image.png",
                ),
                Contact(
                    "Patrick Portes",
                    "(11) 01234-5678",
                    "image.png",
                ),
                Contact(
                    "Patrick Portes",
                    "(11) 01234-5678",
                    "image.png",
                ),
                Contact(
                    "Patrick Portes",
                    "(11) 01234-5678",
                    "image.png",
                )
            )
        )
    }
}
