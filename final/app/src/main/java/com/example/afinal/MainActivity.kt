package com.example.afinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.navigation.findNavController
import com.example.afinal.API.APIService
import com.example.afinal.Model.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_item.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://saurav.tech/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        apiService = retrofit.create(APIService::class.java)
        news = mutableListOf()

        Picasso.get()
            .load("https://www.thestatesman.com/wp-content/uploads/2020/03/Tokyo2020.jpg")
            .rotate(90f)
            .into(imageView)

    }
    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.nav_host_fragment).navigateUp()

    companion object {
        lateinit var news: MutableList<News>
        lateinit var instance: MainActivity
        lateinit var apiService: APIService

    }

}