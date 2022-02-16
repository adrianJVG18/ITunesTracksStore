package com.adrian.core.data.framework.retrofit.implementation

import com.adrian.core.data.framework.retrofit.client.ITunesClient
import com.adrian.core.data.framework.retrofit.service.TuneService
import com.adrian.core.data.repository.TrackRepository
import com.adrian.core.domain.model.dto.request.TrackRqDto
import com.adrian.core.domain.model.dto.response.TrackRsDto
import io.reactivex.Single

class RemoteTracksRepository: TrackRepository {

    private val tracksApi = ITunesClient.getRxClient()
        .create(TuneService::class.java)

    override fun loadTracks(tracksRequest: TrackRqDto): Single<List<TrackRsDto>> {
        return tracksApi.getTracks(tracksRequest.term).map {
            it.results
        }
    }
}