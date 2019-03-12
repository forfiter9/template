package com.example.projecttemplate.shared.api.endpoints

import com.example.projecttemplate.shared.models.User
import io.reactivex.Single
import retrofit2.http.GET

interface IGitEndpoints {

    @GET("users")
    fun getUsers(): Single<Array<User>>

}
