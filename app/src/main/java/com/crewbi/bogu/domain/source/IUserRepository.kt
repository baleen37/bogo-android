package com.crewbi.bogu.domain.source

import com.crewbi.bogu.domain.net.response.VoidRes
import io.reactivex.Observable

/**
 * Created by baleen37@gmail.com on 14/09/2017.
 */
interface IUserRepository {
    fun registerPushToken(uuid: String, token: String): Observable<VoidRes>
}
