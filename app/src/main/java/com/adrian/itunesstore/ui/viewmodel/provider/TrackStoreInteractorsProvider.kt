package com.adrian.itunesstore.ui.viewmodel.provider

import com.adrian.core.data.framework.retrofit.implementation.RemoteTracksRepository
import com.adrian.core.data.repository.TrackRepository
import com.adrian.core.domain.interactor.GetRemoteTracksUseCase
import com.example.commons.usecase.data.job.JobExecutor
import com.example.commons.usecase.data.job.UIThread
import com.adrian.commons.interactors.executor.PostExecutionThread
import com.example.commons.usecase.domain.executor.ThreadExecutor

class TrackStoreInteractorsProvider {

    private val threadExecutor: ThreadExecutor = JobExecutor()

    private val uiThread: PostExecutionThread = UIThread()

    private val trackRepository: TrackRepository by lazy {
        RemoteTracksRepository()
    }

    val searchTracksUseCase: GetRemoteTracksUseCase by lazy {
        GetRemoteTracksUseCase(threadExecutor, uiThread, trackRepository)
    }

}