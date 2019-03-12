package com.example.projecttemplate.shared.di


import com.example.projecttemplate.gitusers.viewmodels.GitUsersFragmentViewModel
import com.example.tomek.cardsgame.shared.api.services.GitService
import dagger.Module
import dagger.Provides

@Module
class ViewModelsModule {

    @Provides
    fun gitUsersFragmentViewModel(gitService: GitService): GitUsersFragmentViewModel {
        return GitUsersFragmentViewModel(gitService)
    }

}