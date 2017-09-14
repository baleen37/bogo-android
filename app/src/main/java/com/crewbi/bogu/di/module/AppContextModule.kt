package com.crewbi.bogu.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by baleen37@gmail.com on 14/09/2017.
 */
@Module
class AppContextModule(val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application
    }
}