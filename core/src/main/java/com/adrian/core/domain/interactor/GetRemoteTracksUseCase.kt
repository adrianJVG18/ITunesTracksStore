package com.adrian.core.domain.interactor

import com.adrian.commons.interactors.usecases.SingleUseCase
import com.adrian.core.data.repository.TrackRepository
import com.adrian.core.domain.exception.UseCaseException
import com.adrian.core.domain.model.dto.request.TrackRqDto
import com.adrian.core.domain.model.dto.response.TrackRsDto
import com.adrian.commons.interactors.executor.PostExecutionThread
import com.example.commons.usecase.domain.executor.ThreadExecutor
import io.reactivex.Single

class GetRemoteTracksUseCase(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val trackRepository: TrackRepository
): SingleUseCase<TrackRqDto, List<TrackRsDto>>(threadExecutor, postExecutionThread)  {

    override fun buildUseCase(params: TrackRqDto?): Single<List<TrackRsDto>> {
        return params?.let {
            trackRepository.loadTracks(it)
        } ?: Single.error(UseCaseException.GenericException())
    }
}