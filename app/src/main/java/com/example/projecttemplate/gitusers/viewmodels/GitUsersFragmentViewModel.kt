package com.example.projecttemplate.gitusers.viewmodels

import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import com.android.databinding.library.baseAdapters.BR
import com.example.projecttemplate.R
import com.example.projecttemplate.gitusers.navigators.GitUsersFragmentNavigator
import com.example.projecttemplate.shared.adapters.RecyclerViewData
import com.example.projecttemplate.shared.models.User
import com.example.projecttemplate.shared.viewmodels.BaseViewModel
import com.example.tomek.cardsgame.shared.api.services.GitService
import javax.inject.Inject


class GitUsersFragmentViewModel @Inject constructor(private val gitService: GitService) : BaseViewModel<GitUsersFragmentNavigator>() {

    val dataDownloading = ObservableBoolean(false)

    val users = object : RecyclerViewData<User>() {
        override val itemHandler: Int = -1
        override val itemBindID: Int = BR.userModel
        override val items = ObservableArrayList<User>()
        override fun itemLayoutID(viewType: Int) = R.layout.user_row
    }

    override fun createdView() {
        super.createdView()
        getUsers()
    }

    fun getUsers() {
        dataDownloading.set(true)
        gitService.getUsers().subscribe(
            {
                dataDownloading.set(false)
                it.forEach { user -> users.items.add(user) }
                navigator?.success()
            },
            {
                dataDownloading.set(false)
                navigator?.failed()
            })
    }

    override fun isDisposed(): Boolean = disposeBag.isDisposed

    override fun dispose() {
        disposeBag.dispose()
    }
}