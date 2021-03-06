package com.movie.bestrelases.di

import android.app.Application
import com.example.core.base.di.AppModule
import com.movie.bestrelases.app.BestReleasesApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class]
)

interface AppComponent {

    fun inject(app: BestReleasesApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}