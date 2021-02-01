package com.project.covilog.Adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.covilog.Models.CountryList
import com.project.covilog.R
import com.squareup.picasso.Picasso


class CountryAdapter(private val context: Context, private val countryList: CountryList): RecyclerView.Adapter<CountryAdapter.ViewHolder>() {



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var countryFlag=itemView.findViewById<ImageView>(R.id.countryFlag)
        var countryName= itemView.findViewById<TextView>(R.id.countryName)
        var totalCases= itemView.findViewById<TextView>(R.id.totalCases)
        var totalRecovered= itemView.findViewById<TextView>(R.id.totalRecovered)
        var totalDeaths= itemView.findViewById<TextView>(R.id.totalDeaths)
        var activeCases= itemView.findViewById<TextView>(R.id.activeCases)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  view= LayoutInflater.from(context).inflate(R.layout.country_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val detail=countryList[position]
        Picasso.get().load(detail.countryInfo.flag).into(holder.countryFlag)
        holder.countryName.text= "Country Name : ${detail.country}"
        holder.totalCases.text= "Total Cases : ${detail.cases.toString()}"
        holder.activeCases.text= "Active Cases : ${detail.active.toString()}"
        holder.totalRecovered.text= "Total Recovered : ${detail.recovered.toString()}"
        holder.totalDeaths.text= "Total Deaths : ${detail.deaths.toString()}"


    }

    override fun getItemCount(): Int {
        return countryList.size
    }


}