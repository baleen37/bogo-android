package com.crewbi.bogu.domain.source.remote

import com.crewbi.bogu.App
import com.crewbi.bogu.domain.net.response.VoidRes
import com.crewbi.bogu.domain.net.service.BoguService
import com.crewbi.bogu.domain.source.IUserRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by baleen37@gmail.com on 14/09/2017.
 */
class UserRemoteSource : IUserRepository {
    @Inject
    lateinit var boguService: BoguService

    init {
        App.graph.inject(this)
    }

    override fun registerPushToken(uuid: String, token: String): Observable<VoidRes> {
        return boguService.registerPushToken(uuid, token)
    }
}