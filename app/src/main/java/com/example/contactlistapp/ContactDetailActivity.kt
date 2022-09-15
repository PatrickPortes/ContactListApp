package com.example.contactlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contact_detail.*
import kotlinx.android.synthetic.main.activity_contact_detail.toolbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.contact_item.*

class ContactDetailActivity : AppCompatActivity() {

    private var contact: Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        initToolbar()
        getExtras()
        bindViews()
    }

    //Inicializando ToolBar
    private fun initToolbar(){
        val toolbar = toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    //Recuperando os Dados da Tela Anterior
    private fun getExtras(){
        contact = intent.getParcelableExtra(EXTRA_CONTACT)
    }

    //Setando os Dados na Tela (fazendo um bind)
    private fun bindViews(){

        textViewNameContactDetail.text = contact?.name
        textViewPhoneContactDetail.text = contact?.phone

    }
    companion object{
        const val EXTRA_CONTACT: String = "EXTRA_CONTACT"
    }

    //Implementando a função do botão voltar da toolbar
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}