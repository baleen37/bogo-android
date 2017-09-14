package com.crewbi.bogu.domain.net.service

import com.crewbi.bogu.domain.net.response.VoidRes
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by baleen37@gmail.com on 14/09/2017.
 */
interface BoguService {

    @FormUrlEncoded
    @POST("/api/v1/push_token")
    fun registerPushToken(@Field("uuid") uuid: String, @Field("token") token: String): Observable<VoidRes>
}