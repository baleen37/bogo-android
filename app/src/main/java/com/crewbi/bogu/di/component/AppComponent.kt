package com.crewbi.bogu.di.component

import com.crewbi.bogu.di.module.AppContextModule
import com.crewbi.bogu.di.module.NetModule
import com.crewbi.bogu.di.module.RepositoryModule
import com.crewbi.bogu.domain.source.remote.UserRemoteSource
import com.crewbi.bogu.presenter.service.MyFirebaseInstanceIDService
import dagger.Component
import javax.inject.Singleton

/**
 * Created by baleen37@gmail.com on 14/09/2017.
 */
@Singleton
@Component(modules = arrayOf(
        AppContextModule::class,
        RepositoryModule::class,
        NetModule::class
))
interface AppComponent {
    fun inject(userRemoteSource: UserRemoteSource)

    fun inject(myFirebaseInstanceIDService: MyFirebaseInstanceIDService)
}