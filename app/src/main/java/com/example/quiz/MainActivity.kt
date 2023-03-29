package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_start : Button = findViewById(R.id.bt1)
        val name : EditText = findViewById(R.id.name)
        btn_start.setOnClickListener{
            if(name.text.isEmpty()){
                Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this, Quest::class.java)
                startActivity(intent)

            }
        }

    }

}