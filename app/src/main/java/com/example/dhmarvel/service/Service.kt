package com.example.dhmarvel.service

import com.example.dhmarvel.entities.JsonApiMarvel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Repository {

    //Id:1009610 corresponde ao SpiderMan:
    @GET("characters/1009610/comics")
    suspend fun getHqs(
            @Query("orderBy") orderBy: String,
            @Query("offset") offset: Int,
            @Query("limit") limit: Int,
            @Query("ts") ts: Int,
            @Query("apikey") apikey:String,
            @Query("hash") hash:String
    ): JsonApiMarvel
}


val retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com/v1/public/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

val repository:Repository = retrofit.create(Repository::class.java)