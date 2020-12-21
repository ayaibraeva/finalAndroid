package com.example.afinal.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.afinal.Adapter.Adapter
import com.example.afinal.MainActivity
import com.example.afinal.Model.News
import com.example.afinal.R
import kotlinx.android.synthetic.main.first_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragment(): Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewNews.adapter =
            Adapter(view.context)
        recyclerViewNews.layoutManager = LinearLayoutManager(view.context)
        MainActivity.apiService.getNews().enqueue(object : Callback<MutableList<News>> {
            override fun onFailure(call: Call<MutableList<News>>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }
            override fun onResponse(call: Call<MutableList<News>>, response: Response<MutableList<News>>) {
                Log.e("Response: ", response.body()!!.size.toString())
                MainActivity.news = response.body()!!
                (recyclerViewNews.adapter as Adapter).notifyDataSetChanged()
            }
        })
    }
}