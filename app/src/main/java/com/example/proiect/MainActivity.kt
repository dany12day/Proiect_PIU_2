package com.example.proiect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.proiect.Util.UserInfo
import com.google.android.material.textfield.TextInputEditText
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    //private val jokeApi = JokeApi.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameError = findViewById<TextView>(R.id.usernameError)
        val passwordError = findViewById<TextView>(R.id.passwordError)

        val usernameInput = findViewById<TextInputEditText>(R.id.usernameInput)
        val passwordInput = findViewById<TextInputEditText>(R.id.passwordInput)

        usernameInput.doOnTextChanged{text, start, before, count ->
            usernameError.text = when(text.toString().length){
                0 -> "username cannot be empty "
                in 1..3 -> "username too short"
                else -> ""
            }

        }

        passwordInput.doOnTextChanged{text, start, before, count ->
            passwordError.text = when(text.toString().length){
                0 -> "password cannot be empty "
                in 1..3 -> "password too short"
                else -> ""
            }

        }

        val button = findViewById<Button>(R.id.loginButton)
        button.setOnClickListener {
            val usernameVal = usernameInput.text.toString()
            val passwordVal = passwordInput.text.toString()

            UserInfo.username = usernameVal

            if ( usernameVal == "admin" && passwordVal == "password")
            {
                val intent = Intent(this@MainActivity, JokeActivity::class.java)
                startActivity(intent)
            }



        }
        val globalLogoutButton = findViewById<Button>(R.id.globalLogoutButton)
        globalLogoutButton.setOnClickListener{
            val usernameVal = usernameInput.text.toString()
            val passwordVal = passwordInput.text.toString()



        }

    }

}