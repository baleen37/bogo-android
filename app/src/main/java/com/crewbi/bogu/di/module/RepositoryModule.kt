package com.crewbi.bogu.di.module

import com.crewbi.bogu.domain.source.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by baleen37@gmail.com on 14/09/2017.
 */
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(): UserRepository {
        return UserRepository()
    }
}