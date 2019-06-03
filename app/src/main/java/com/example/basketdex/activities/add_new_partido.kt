package com.example.basketdex.activities

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.basketdex.R
import kotlinx.android.synthetic.main.add_new_partido.*
import kotlinx.android.synthetic.main.list_element_partido.*
import java.lang.reflect.Array.set


class add_new_partido : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_new_partido)


        abtn1.setOnClickListener {
            var scorea: Int
            var n_score: String

            scorea=Integer.parseInt(n_scorea.getText().toString())
            scorea+1
            n_score=Integer.toBinaryString(scorea)
            n_scorea.setText(n_score)
        }

        abtn2.setOnClickListener {
            var scorea: Int
            var n_score: String

            scorea=Integer.parseInt(n_scorea.getText().toString())
            scorea+2
            n_score=Integer.toBinaryString(scorea)
            n_scorea.setText(n_score)
        }

        abtn3.setOnClickListener {
            var scorea: Int
            var n_score: String

            scorea=Integer.parseInt(n_scorea.getText().toString())
            scorea+3
            n_score=Integer.toBinaryString(scorea)
            n_scorea.setText(n_score)
        }
    }


}