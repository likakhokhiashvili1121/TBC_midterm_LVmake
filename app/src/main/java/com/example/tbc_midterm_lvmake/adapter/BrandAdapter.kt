package com.example.tbc_midterm_lvmake.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tbc_midterm_lvmake.R
import com.example.tbc_midterm_lvmake.adapter.BrandAdapter.MyViewHolder
import com.example.tbc_midterm_lvmake.model.BrandModel
import kotlinx.android.synthetic.main.hor_rec_resource.view.*


class BrandAdapter(private val res: List<BrandModel>) : RecyclerView.Adapter<MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(brandModel: BrandModel){
            itemView.name.text=brandModel.brand
            Glide.with(itemView.imageView.context)
                .load(brandModel.link)
                .into(itemView.imageView)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.hor_rec_resource,parent,false)
        val viewHolder=MyViewHolder(view)

        view.setOnClickListener{

            val txt=res[viewHolder.adapterPosition].brand.toLowerCase()
            Toast.makeText(parent.context,txt,Toast.LENGTH_SHORT).show()

            view.findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard)

        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =holder.bind(res[position])

    override fun getItemCount(): Int = res.count()
}


