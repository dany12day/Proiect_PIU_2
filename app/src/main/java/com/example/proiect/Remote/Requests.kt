package com.example.proiect.Remote

import com.example.proiect.Jokes.Joke
import com.google.gson.annotations.SerializedName
import org.json.JSONObject

sealed class Requests {

    data class GetJokes(
        val messages: Joke
    )
}
