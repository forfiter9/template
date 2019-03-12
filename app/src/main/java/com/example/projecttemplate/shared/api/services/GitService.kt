package com.example.tomek.cardsgame.shared.api.services

import com.example.projecttemplate.shared.api.endpoints.IGitEndpoints
import com.example.projecttemplate.shared.models.User
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

interface IGitService {
    fun getUsers(): Single<Array<User>>
}

open class GitService @Inject constructor(private val api: IGitEndpoints) : IGitService {
    override fun getUsers(): Single<Array<User>> {
        return api.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())}
}