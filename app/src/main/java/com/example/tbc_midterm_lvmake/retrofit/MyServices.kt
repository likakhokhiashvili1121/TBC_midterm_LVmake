package com.example.tbc_midterm_lvmake.retrofit

import com.example.tbc_midterm_lvmake.model.MyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MyServices {

    @GET("api/v1/products.json")
    suspend fun getData(/*@Query("brand") brand: String, @Query("api_key") key: String*/ ): List<MyResponse>
    @GET("api/v1/products.json")
    suspend fun getData2(@Query("brand") brand: String): List<MyResponse>
    @GET("api/v1/products.json")
    suspend fun getData3(@Query("category") category: String): List<MyResponse>
}
