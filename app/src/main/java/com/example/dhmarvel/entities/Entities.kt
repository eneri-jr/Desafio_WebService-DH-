package com.example.dhmarvel.entities

import java.io.Serializable


data class JsonApiMarvel(
        val data: Data
)

data class Data(
        val offset: Int,
        val results: ArrayList<Hq>
)

data class Hq(
        val id: Int,
        var title: String,
        var description: String,
        var pageCount: Int,
        var dates: ArrayList<Date>,
        var prices: ArrayList<Price>,
        val images: ArrayList<Images>
): Serializable{

}

data class Date(
    val type: String,
    val date: String
): Serializable{

}

data class Price(
        val type: String,
        val price: Float
): Serializable{

}

data class Images(
        val path: String,
        val extension: String
): Serializable{

}



