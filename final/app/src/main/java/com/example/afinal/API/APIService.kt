package com.example.afinal.API

import com.example.afinal.Model.News
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("top-headlines/category/business/us.json")
    fun getNews(): Call<MutableList<News>>


}