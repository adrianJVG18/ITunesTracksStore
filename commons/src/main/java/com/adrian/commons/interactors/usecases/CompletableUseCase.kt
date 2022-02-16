package com.adrian.commons.interactors.usecases

import com.adrian.commons.interactors.executor.PostExecutionThread
import com.example.commons.usecase.domain.executor.ThreadExecutor
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers

abstract class CompletableUseCase<Params>(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
): UseCase<Params, Completable>() {

    fun execute(params: Params? = null): Completable {
        return buildUseCase(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.getScheduler())
    }
}