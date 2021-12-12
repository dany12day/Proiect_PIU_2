package com.example.proiect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import com.example.proiect.Remote.JokesApi
import com.example.proiect.Remote.Requests
import com.example.proiect.Util.UserInfo
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class JokeActivity : AppCompatActivity() {

    private val jokesApi = JokesApi.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)

        val greetingsUser = findViewById<TextView>(R.id.greetingsUser)
        greetingsUser.text = "Hello " + UserInfo.username

        val button = findViewById<Button>(R.id.All)
        button.setOnClickListener {


            jokesApi.getJokesAny(

            ).enqueue(object: Callback<Requests.GetJokes> {
                override fun onResponse(
                    call: Call<Requests.GetJokes>,
                    response: Response<Requests.GetJokes>
                ) {
                    if (response.isSuccessful){
                        val messages = response.body()!!.messages
                        val mes = messages

                    }
                }

                override fun onFailure(call: Call<Requests.GetJokes>, t: Throwable) = Unit

            })

        }
    }
}