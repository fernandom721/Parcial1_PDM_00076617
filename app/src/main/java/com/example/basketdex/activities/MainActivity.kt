package com.example.basketdex.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basketdex.PartidoAdapter
import com.example.basketdex.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var adapater: PartidoAdapter
    lateinit var viewModel: PartidoAdapter

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        btn_new_partido.setOnClickListener {
            val intent= Intent(this, add_new_partido::class.java)
            startActivity(intent)
        }
    }

    private fun bind(){
        adapater = PartidoAdapter(ArrayList())
        //viewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)
        recycleview.apply {
            adapter = this@MainActivity.adapater
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }

}
