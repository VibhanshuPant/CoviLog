package com.project.covilog.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.covilog.APIService.CountryAPI
import com.project.covilog.Adapter.CountryAdapter
import com.project.covilog.Models.CountryList
import com.project.covilog.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit= Retrofit.Builder()
            .baseUrl("https://disease.sh/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api=retrofit.create(CountryAPI::class.java)
        api.getCountryList().enqueue(object : Callback<CountryList> {
            override fun onResponse(call: Call<CountryList>, response: Response<CountryList>) {
                showData(response.body()!!)
            }

            override fun onFailure(call: Call<CountryList>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Something went wrong $t", Toast.LENGTH_SHORT).show()
            }

        })
    }
    private fun showData(countryList: CountryList) {
        val recyclerview=findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.apply {
            layoutManager= LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter= CountryAdapter(context,countryList)
        }
    }
}