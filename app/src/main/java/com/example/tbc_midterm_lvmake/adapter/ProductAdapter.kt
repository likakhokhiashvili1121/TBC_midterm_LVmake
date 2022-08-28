package com.example.tbc_midterm_lvmake.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tbc_midterm_lvmake.ui.dashboard.DashboardFragment
import com.example.tbc_midterm_lvmake.R
import com.example.tbc_midterm_lvmake.model.MyResponse
import kotlinx.android.synthetic.main.slider_horizon.view.*


class ProductAdapter(private val res: List<MyResponse>) : RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.slider_horizon,parent,false)
        val viewHolder= MyViewHolder(view)
        view.setOnClickListener{
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)=holder.bind(res[position])

    override fun getItemCount(): Int = res.count()

    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(myResponse: MyResponse){
            itemView.productName.text=myResponse.name
            itemView.category.text=myResponse.description
            itemView.price.text= myResponse.price
            Glide.with(itemView.img.context)
                    .load(myResponse.imageLink)
                    .into(itemView.img)

            itemView.buy.setOnClickListener {
                val dashboardFragment = DashboardFragment()
                dashboardFragment.showMyDialog(it.context)
            }
        }

    }
}