package com.example.proiect.Remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface JokesApi {

    @Headers(contentTypeJson)
    @GET(ANY)
    fun getJokesAny(
    ): Call<Requests.GetJokes>

    companion object{
        private val logger = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        private val httpClient = OkHttpClient.Builder().apply {
            addInterceptor(logger)
        }.build()

        fun create(): JokesApi{
            val retrofitInstance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()

            return retrofitInstance.create(JokesApi::class.java)
        }
    }
}

private const val BASE_URL = "https://v2.jokeapi.dev/joke/"
private const val ANY = "Any"
private const val contentTypeJson = "Content-Type: application/json"