package com.adrian.core.data.repository

import com.adrian.core.domain.model.dto.request.TrackRqDto
import com.adrian.core.domain.model.dto.response.TrackRsDto
import io.reactivex.Single

interface TrackRepository {
    fun loadTracks(tracksRequest: TrackRqDto): Single<List<TrackRsDto>>
}