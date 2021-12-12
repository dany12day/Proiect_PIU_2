package com.example.proiect.Jokes

data class Flags (
    val nsfw: Boolean? = false,
    val religious: Boolean? = false,
    val political: Boolean? = false,
    val racist: Boolean? = false,
    val sexist: Boolean? = false,
    val explicit: Boolean? = false
)
