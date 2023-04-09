package com.example.quiz


import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class questSet : BaseActivity() {

   private var questSet : EditText? = null
    private var setOption1 : EditText ? = null
    private var setOption2 : EditText ? = null
    private var setOption3 : EditText ? = null
    private var setOption4 : EditText ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest_set)

         questSet = findViewById(R.id.questSet)
         setOption1 = findViewById(R.id.set_option1)
         setOption2 = findViewById(R.id.set_option2)
        setOption3 = findViewById(R.id.set_option3)
        setOption4 = findViewById(R.id.set_option4)

         val submitQuest = findViewById<Button>(R.id.submit_questSet)

        submitQuest.setOnClickListener {
         postQuest()

           // Toast.makeText(this,"This is working", Toast.LENGTH_LONG).show()
        }
    }


    private fun postQuest(){
        val et_quest : String  = questSet?.text.toString().trim{ it<= ' '}
        val et_option1 : String  = setOption1?.text.toString().trim{ it <= ' '}
        val et_option2 : String  = setOption2?.text.toString().trim{ it <= ' '}
        val et_option3 : String  = setOption3?.text.toString().trim{ it<= ' '}
        val et_option4 : String  = setOption4?.text.toString().trim{ it <= ' '}

        if(validate(et_quest, et_option1, et_option2, et_option3, et_option4)) {
            Toast.makeText(this@questSet, "$et_option1", Toast.LENGTH_LONG).show()
        }
    }

    private fun validate(et_quest: String , et_option1: String, et_option2: String, et_option3: String, et_option4: String):Boolean{
       return when{
            TextUtils.isEmpty(et_quest) -> {
                showErrorSnackBar("Please fill all the blanks")
                false
            }
           TextUtils.isEmpty(et_option1) -> {
               showErrorSnackBar("Please fill all the blanks")
               false
           }
           TextUtils.isEmpty(et_option2) -> {
               showErrorSnackBar("Please fill all the blanks")
               false
           }
           TextUtils.isEmpty(et_option3) -> {
               showErrorSnackBar("Please fill all the blanks")
               false
           }
           TextUtils.isEmpty(et_option4) -> {
               showErrorSnackBar("Please fill all the blanks")
               false
           }
           else -> {
               true
           }
       }


        }
    }
