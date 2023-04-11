package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.quiz.activities.questSet

class AdminDash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_dash)
         val quiz1 = findViewById<Button>(R.id.quiz1)

        quiz1?.setOnClickListener{
            startActivity(Intent(this, questSet::class.java))
            finish()
        }
    }
}