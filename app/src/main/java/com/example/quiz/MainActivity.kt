package com.example.quiz

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app

class MainActivity : BaseActivity() {
    private lateinit var auth: FirebaseAuth
    private var name : EditText ? = null
    private var pass : EditText ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth

        val btn_start : Button = findViewById(R.id.bt1)
        name = findViewById(R.id.name)
        pass = findViewById(R.id.password)


        btn_start.setOnClickListener{
            signIn()
        }

    }
    private fun signIn(){
        val et_email : String = name?.text.toString().trim{ it <= ' '}
        val et_pass : String = pass?.text.toString().trim{ it <= ' '}

        if(validate(et_email, et_pass)){
            showProgressDialog(resources.getString(R.string.please_wait))

            auth.signInWithEmailAndPassword(et_email, et_pass)
                .addOnCompleteListener(this) { task ->
                    hideProgressDialog()
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Sign in", "signInWithEmail:success")
                        val user = auth.currentUser
                        startActivity(Intent(this, questSet::class.java))
                        finish()

                       // updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("Sign in", "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                       // updateUI(null)
                    }
                }
        }
    }

    private fun validate(et_email : String, et_pass : String):Boolean{
        return when{
            TextUtils.isEmpty(et_email) -> {
                showErrorSnackBar("Please fill all the blanks")
                false
            }
            TextUtils.isEmpty(et_pass) -> {
                showErrorSnackBar("Please fill all the blanks")
                false
            }
            else -> {
                true
            }
        }

    }

}