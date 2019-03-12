package com.example.projecttemplate.gitusers.viewmodels

import com.example.projecttemplate.gitusers.navigators.GitUsersActivityNavigator
import com.example.projecttemplate.shared.viewmodels.BaseViewModel
import javax.inject.Inject

class GitUsersActivityViewModel @Inject constructor() :
    BaseViewModel<GitUsersActivityNavigator>() {

    override fun isDisposed(): Boolean = disposeBag.isDisposed

    override fun dispose() {
        disposeBag.dispose()
    }
}