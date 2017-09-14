package com.crewbi.bogu.domain.source.repository

import com.crewbi.bogu.domain.net.response.VoidRes
import com.crewbi.bogu.domain.source.IUserRepository
import com.crewbi.bogu.domain.source.remote.UserRemoteSource
import io.reactivex.Observable

/**
 * Created by baleen37@gmail.com on 14/09/2017.
 */
class UserRepository : IUserRepository {
    val userRemoteSource = UserRemoteSource()

    override fun registerPushToken(uuid: String, token: String): Observable<VoidRes> {
        return userRemoteSource.registerPushToken(uuid = uuid, token = token)
    }

}