package com.example.databaseinandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SharedPreferencePrac : AppCompatActivity() {

    lateinit var email : EditText
    lateinit var pwd : EditText
    lateinit var btn : Button
    lateinit var detail : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference_prac)


        email = findViewById(R.id.email)
        pwd = findViewById(R.id.password)
        btn = findViewById(R.id.btn)
        detail = findViewById(R.id.sharedprefdata)

        val mydata = getSharedPreferences("MyDatabase", MODE_PRIVATE)
        val emaildata = mydata.getString("Email",null)
        val passdata = mydata.getString("Pass",null)

        btn.setOnClickListener {

            if (email == null || pwd == null) {
                Toast.makeText(this, "Please Enter Email and Password", Toast.LENGTH_SHORT).show()
            } else {
                val myData = mydata.edit()

                myData.putString("Email",email.text.toString())
                myData.putString("Pass",pwd.text.toString())
                myData.apply()
            }
            intent = Intent(this@SharedPreferencePrac, MainActivity::class.java)
            startActivity(intent)
//            finish()
        }


//
//        if(email != null && pwd != null){
//            detail.text =  "Email id :- $emaildata & Password :- $passdata"
//        }
    }

    override fun onStart() {
        super.onStart()

        if(email != null && pwd != null) {

            intent = Intent(this@SharedPreferencePrac, MainActivity::class.java)
            startActivity(intent)
        }
    }
}