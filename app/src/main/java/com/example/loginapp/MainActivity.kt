package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.text.style.ClickableSpan
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity



class MainActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.EmailAddress)
        val password = findViewById<EditText>(R.id.TextPassword)
        val submit = findViewById<Button>(R.id.button)
        val register= findViewById<TextView>(R.id.register)

        submit.setOnClickListener() {

            if (username.text.toString()=="pranam" && password.text.toString()=="12345") {
                startActivity(Intent(this, thirdActivity::class.java))
                Toast.makeText(this, "login successful", Toast.LENGTH_SHORT).show()

            }
            else if (username.text.isNullOrEmpty()){
                username.error = "Enter username"
            }
            else if (password.text.isNullOrEmpty()){
                password.error = "Enter password"
            }
            else{
                Toast.makeText(this, "login failed \n Enter correct Username and password", Toast.LENGTH_LONG).show()
            }
        }

        register.setOnClickListener(){
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }


}