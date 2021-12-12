package com.example.proiect.Jokes

import com.google.gson.annotations.SerializedName

data class Joke (
    val error: Boolean? = false,
    val category: String? = "",
    val type: String? = "",
    val joke: String? = "",
    val flags: Flags? = null,
    val id: Int? = 0,
    val safe: Boolean? = false,
    val lang: String? = ""
)