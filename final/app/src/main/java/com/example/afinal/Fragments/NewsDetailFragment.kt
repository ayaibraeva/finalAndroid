package com.example.afinal.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.afinal.MainActivity
import com.example.afinal.Model.News
import com.example.afinal.R
import kotlinx.android.synthetic.main.news_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsDetailFragment: Fragment() { override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    return inflater.inflate(R.layout.news_detail, container, false)
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





//        MainActivity.apiService.getNews().enqueue(object : Callback<News> {
//            override fun onFailure(call: Call<News>, t: Throwable) {
//                Log.e("Error", t.message.toString())
//            }
//
//            override fun onResponse(call: Call<News>, response: Response<News>) {
//                Log.e("Response: ", response.body()!!.toString())
//
//                val list = response.body()!!
//                news_detail_title.text = list.title
//                bodyTextView.text = list.content
//
//
//            }
//        })

    }
}