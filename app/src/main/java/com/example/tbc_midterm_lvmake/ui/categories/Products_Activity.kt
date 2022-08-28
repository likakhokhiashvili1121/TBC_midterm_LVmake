package com.example.tbc_midterm_lvmake.ui.categories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.example.tbc_midterm_lvmake.adapter.CategoryAdapter
import com.example.tbc_midterm_lvmake.ui.dashboard.DashboardViewModel
import com.example.tbc_midterm_lvmake.R
import kotlinx.android.synthetic.main.activity_products_.*
import kotlinx.coroutines.DelicateCoroutinesApi
import java.lang.Exception

class Products_Activity : AppCompatActivity() {
    private lateinit var myViewModel: DashboardViewModel

    //binding

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_)


        try {
            val bundle = intent.extras
            var s = bundle!!.getString("cat")
            var i = bundle.getInt("con")

            myViewModel = ViewModelProvider(this)[DashboardViewModel::class.java]
            myViewModel.makeupResponse(s.toString(), i)

            val recyclerView2: RecyclerView = findViewById(R.id.product_recycle)
            recyclerView2.setHasFixedSize(true)
            recyclerView2.itemAnimator = DefaultItemAnimator()


            myViewModel.properties.observe(this) {
                progresss.visibility = View.GONE
                recyclerView2.adapter = CategoryAdapter(it)
            }
        }
        catch (e:Exception){
            Log.i("------",e.localizedMessage)
        }


    }
    
}