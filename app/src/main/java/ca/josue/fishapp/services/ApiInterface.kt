package ca.josue.fishapp.services

import ca.josue.fishapp.model.*
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @GET("products")
    fun getProducts() : Call<List<Product>>

    // https://fish-sales-application.herokuapp.com/api/v1/users/login
    @POST("users/login")
    fun login(@Body user : UserDTO) : Call<MyLogin>

    // https://fish-sales-application.herokuapp.com/api/v1/orders/get/userorder/{id}
    @GET("orders/get/userorder/{id}")
    fun getMyCommands(
            @Path("id") id_user_current : String
    ) : Call<List<MyCommandesItem>>

    @GET("users/{id}")
    fun getInfoUser(
            @Path("id") idUser : String
    ) : Call<UserResponse>

}