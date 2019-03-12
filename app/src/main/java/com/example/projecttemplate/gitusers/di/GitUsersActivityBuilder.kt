package com.example.projecttemplate.gitusers.di

import com.example.projecttemplate.gitusers.ui.GitUsersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class GitUsersActivityBuilder {
    @ContributesAndroidInjector
    abstract fun bindGitUsersFragment(): GitUsersFragment
}