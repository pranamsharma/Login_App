package com.example.loginapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val signup = findViewById<Button>(R.id.SignButton)
        val phone = findViewById<EditText>(R.id.phone_number)
        val name =findViewById<EditText>(R.id.Name)
        val username=findViewById<EditText>(R.id.EmailAddress)
        val password= findViewById<EditText>(R.id.TextPassword)

        val sharedPrefFile = "SIGN_INFO"
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)
        signup.setOnClickListener {
            fun getPreferenceString(key_name: String): String? {

                val emailId: String = username.text.toString()
                val Name: String = name.text.toString()
                val pass: String = password.text.toString()
                val number: String = phone.text.toString()

                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("email_id", emailId)
                editor.putString("name", Name)
                editor.putString("password", pass)
                editor.putString("phone no.", number)
                editor.apply()
                editor.commit()

                return sharedPrefFile
            }



            Toast.makeText(this,"You're Registered now", Toast.LENGTH_SHORT).show()

            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

    }
}


