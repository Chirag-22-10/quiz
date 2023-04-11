package com.example.quiz.activities

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.quiz.AdminDash
import com.example.quiz.firebase.BaseActivity
import com.example.quiz.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : BaseActivity() {
    private lateinit var auth: FirebaseAuth
    private var name : EditText ? = null
    private var pass : EditText ? = null
    private val db = Firebase.firestore
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

                        startActivity(Intent(this, AdminDash::class.java))
                        finish()

                       // updateUI(user)
                       // readData()
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
                showErrorSnackBar("Please enter proper username")
                false
            }
            TextUtils.isEmpty(et_pass) -> {
                showErrorSnackBar("Please enter proper password")
                false
            }
            else -> {
                true
            }
        }

    }

//    private fun readData() {
//        val docRef = db.collection("Users").document("mgOUwB9hI0rnnKhQkAU8")
//        docRef.get()
//            .addOnSuccessListener {
//                if (it != null) {
//                   val Role = it.data?.get("Role")?.toString()
//                    Toast.makeText(this, "$Role", Toast.LENGTH_LONG).show()
//
//                } else {
//                    Toast.makeText(this, "No data", Toast.LENGTH_LONG).show()
//                }
//            }
//            .addOnFailureListener {
//                Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
//            }
//    }

}