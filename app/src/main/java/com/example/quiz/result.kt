package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName : TextView = findViewById(R.id.user_name)
        val tvscore : TextView =  findViewById(R.id.total_score)
        val tbtnfinish : TextView =  findViewById(R.id.btn_finish)

        tvName.text = intent.getStringExtra(Const.USER_NAME)

        val totalQuestion = intent.getIntExtra(Const.TOTAL_QUESTION,0)
        val correctAnswer = intent.getIntExtra(Const.CORRECT_ANSWER,0)

        tvscore.text = "Your Score is $correctAnswer of $totalQuestion"

        tbtnfinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }



    }
}