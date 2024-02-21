package com.example.databaseinandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.databaseinandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userdata = getSharedPreferences("MyDatabase", MODE_PRIVATE)

        val useremail = userdata.getString("Email",null)
        binding.useremail.text = "User Email id :- $useremail"

        binding.logout.setOnClickListener {

            val editor = userdata.edit()

            editor.clear()

            editor.apply()

            intent = Intent(this@MainActivity, SharedPreferencePrac::class.java)
            startActivity(intent)
//            finish()
        }

    }
}