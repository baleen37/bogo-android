package com.crewbi.bogu

import android.app.Application
import com.crewbi.bogu.di.component.AppComponent
import com.crewbi.bogu.di.component.DaggerAppComponent
import com.crewbi.bogu.di.module.AppContextModule
import com.crewbi.bogu.di.module.NetModule
import com.crewbi.bogu.di.module.RepositoryModule

/**
 * Created by baleen37@gmail.com on 06/09/2017.
 */
class App : Application() {
    companion object {
        @JvmStatic lateinit var graph: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initDagger()
    }

    private fun initDagger() {
        graph = DaggerAppComponent.builder()
                .appContextModule(AppContextModule(this))
                .repositoryModule(RepositoryModule())
                .netModule(NetModule())
                .build()
    }
}