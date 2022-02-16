package com.adrian.core.domain.model.entity

import com.adrian.core.domain.model.dto.response.TrackRsDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItunesResponse(
    @SerializedName("resultCount")
    @Expose
    val resultCount: Int,
    @SerializedName("results")
    @Expose
    val results: List<TrackRsDto>
)
