package com.example.dhmarvel.entities


data class JsonApiMarvel(
        val data: Data
)

data class Data(
        val offset: Int,
        val results: ArrayList<Hq>
)

class Hq(
        val id: Int,
        val title: String,
        val description: String,
        val pageCount: Int,
        val dates: ArrayList<Date>,
        val prices: ArrayList<Price>,
        val images: ArrayList<Images>
)

data class Date(
    val type: String,
    val date: String
)

data class Price(
        val type: String,
        val price: Float
)

data class Images(
        val path: String,
        val extension: String
)



