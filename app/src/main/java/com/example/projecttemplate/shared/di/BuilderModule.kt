package com.example.projecttemplate.shared.di

import com.example.projecttemplate.gitusers.di.GitUsersActivityBuilder
import com.example.projecttemplate.gitusers.ui.GitUsersActivity
import com.example.tomek.cardsgame.shared.api.services.GitService
import com.example.tomek.cardsgame.shared.api.services.IGitService
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(GitUsersActivityBuilder::class))
    abstract fun bindGitUsersActivity(): GitUsersActivity

    @Binds
    abstract fun gitService(gitService: GitService): IGitService
}