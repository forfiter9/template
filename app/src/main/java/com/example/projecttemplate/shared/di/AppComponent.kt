package com.example.projecttemplate.shared.di

import com.example.projecttemplate.GlobalApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AndroidInjectionModule::class,
    AppModule::class,
    BuilderModule::class,
    NetworkModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(globalApplication: GlobalApplication): Builder

        fun build(): AppComponent
    }

    fun inject(globalApplication: GlobalApplication)
}