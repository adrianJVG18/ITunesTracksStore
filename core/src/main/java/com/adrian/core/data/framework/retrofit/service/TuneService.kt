package com.adrian.core.data.framework.retrofit.service

import com.adrian.core.domain.model.entity.ItunesResponse
import io.reactivex.Single
import retrofit2.http.*

interface TuneService {

    // TODO define correctly endpoint values

    // example:
    // https://itunes.apple.com/search?term=jack+johnson&entity=musicVideo.

    @GET("search?entity=musicTrack")
    fun getTracks(
        @Query("term") term: String,
    ): Single<ItunesResponse>


}