package com.deepshikhayadav.makeupclub.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.deepshikhayadav.makeupclub.R
import com.example.tbc_midterm_lvmake.adapter.BrandAdapter
import com.deepshikhayadav.makeupclub.model.Suppliers
import com.example.tbc_midterm_lvmake.ui.categories.Products_Activity
import com.example.tbc_midterm_lvmake.ui.dashboard.DashboardViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val recyclerView: RecyclerView = root.findViewById(R.id.recycle2)
        val brand=Suppliers.brands
        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator=DefaultItemAnimator()
        recyclerView.adapter= BrandAdapter(brand)

        try {
        val myConst =0
        val bundle = Bundle()
        var intent: Intent
        var category: String

    root.lipstick.setOnClickListener {
        category = root.lipstick1.text.toString().toLowerCase()
        bundle.putString("cat", category)
        bundle.putInt("con", myConst)
        intent = Intent(root.context, Products_Activity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)

    }
    root.pencil.setOnClickListener {
        category = root.pencil1.text.toString().toLowerCase()
        bundle.putString("cat", category)
        bundle.putInt("con", myConst)
        intent = Intent(root.context, Products_Activity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
    root.liquid.setOnClickListener {
        category = root.liquid1.text.toString().toLowerCase()
        bundle.putString("cat", category)
        bundle.putInt("con", myConst)
        intent = Intent(root.context, Products_Activity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
    root.lip_gloss.setOnClickListener {
        category = root.lip_gloss1.text.toString().toLowerCase()
        bundle.putString("cat", category)
        bundle.putInt("con", myConst)
        intent = Intent(root.context, Products_Activity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    root.powder.setOnClickListener {
        category = root.powder1.text.toString().toLowerCase()
        bundle.putString("cat", category)
        bundle.putInt("con", myConst)
        intent = Intent(root.context, Products_Activity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
    root.gel.setOnClickListener {
        category = root.gel1.text.toString().toLowerCase()
        bundle.putString("cat", category)
        bundle.putInt("con", myConst)
        intent = Intent(root.context, Products_Activity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
    root.cream.setOnClickListener {
        category = root.cream1.text.toString().toLowerCase()
        bundle.putString("cat", category)
        bundle.putInt("con", myConst)
        intent = Intent(root.context, Products_Activity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
    root.palette.setOnClickListener {
        category = root.palette1.text.toString().toLowerCase()

        bundle.putString("cat", category)
        bundle.putInt("con", myConst)
        intent = Intent(root.context, Products_Activity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}
catch (e:Exception){
    val c=e.localizedMessage
    Log.i("==========",c)
}
      return root
    }


}