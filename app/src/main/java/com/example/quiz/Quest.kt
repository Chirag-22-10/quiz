package com.example.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class Quest : AppCompatActivity(), View.OnClickListener {

    private var mcurrentPoot: Int = 1
    private var mQuestionList: ArrayList<Questc>? = null
    private var mSelectedopt: Int = 0
    private var mUserName: String? = null
    private var mCorrectAns: Int = 0

    private var progressBar: ProgressBar? = null
    private var txtProgressBar: TextView? = null
    private var tvquestion: TextView? = null
    private var toption1: TextView? = null
    private var toption2: TextView? = null
    private var toption3: TextView? = null
    private var toption4: TextView? = null
    private var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest)

        progressBar = findViewById(R.id.tv_progress_text)
        tvquestion = findViewById(R.id.question)
        toption1 = findViewById(R.id.tv_option1)
        toption2 = findViewById(R.id.tv_option2)
        toption3 = findViewById(R.id.tv_option3)
        toption4 = findViewById(R.id.tv_option4)
        mUserName = intent.getStringExtra(Const.USER_NAME)
        txtProgressBar = findViewById(R.id.tprogress)
        button = findViewById(R.id.Submit)






        mQuestionList = Const.getQuestions()


        defaultOptionsView()
        setQuestions()
        toption1?.setOnClickListener(this)
        toption2?.setOnClickListener(this)
        toption3?.setOnClickListener(this)
        toption4?.setOnClickListener(this)
        button?.setOnClickListener(this)


    }

    private fun setQuestions() {
        defaultOptionsView()
        val question: Questc = mQuestionList!![mcurrentPoot - 1]
        progressBar?.progress = mcurrentPoot
        txtProgressBar?.text = "$mcurrentPoot/${progressBar?.max}"
        tvquestion?.text = question.question
        toption1?.text = question.option1
        toption2?.text = question.option2
        toption3?.text = question.option3
        toption4?.text = question.option4


    }

    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        toption1?.let {
            options.add(0, it)
        }
        toption2?.let {
            options.add(1, it)
        }
        toption3?.let {
            options.add(2, it)
        }
        toption4?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@Quest,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

      defaultOptionsView()

        mSelectedopt = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@Quest,
            R.drawable.selected_option_boder_bg
        )
    }

    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.tv_option1 -> {
                toption1?.let {
                    selectedOptionView(it, 1)
                }

            }

            R.id.tv_option2 -> {
                toption2?.let {
                    selectedOptionView(it, 2)
                }

            }

            R.id.tv_option3 -> {
                toption3?.let {
                    selectedOptionView(it, 3)
                }

            }

            R.id.tv_option4 -> {
                toption4?.let {
                    selectedOptionView(it, 4)
                }

            }
            R.id.Submit ->{
                if(mSelectedopt == 0){
                    mcurrentPoot++

                    when{
                        mcurrentPoot <= mQuestionList!!.size ->{
                            setQuestions()
                        }
                        else -> {
                            val intent = Intent(this, result::class.java)
                            intent.putExtra(Const.USER_NAME, mUserName)
                            intent.putExtra(Const.CORRECT_ANSWER, mCorrectAns)
                            intent.putExtra(Const.TOTAL_QUESTION, mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mcurrentPoot - 1)
                    if(question!!.correctAnswer != mSelectedopt){
                        answerView(mSelectedopt, R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAns++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)


                    if(mcurrentPoot == mQuestionList!!.size){
                        button?.text = "Finish"
                    }else{
                        button?.text = "Next Question"
                    }
                    mSelectedopt = 0
                }
            }
        }
    }
    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1->{
                toption1?.background = ContextCompat.getDrawable(this, drawableView)
            }
            2->{
                toption2?.background = ContextCompat.getDrawable(this, drawableView)
            }
            3->{
                toption3?.background = ContextCompat.getDrawable(this, drawableView)
            }
            4->{
                toption4?.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }
}