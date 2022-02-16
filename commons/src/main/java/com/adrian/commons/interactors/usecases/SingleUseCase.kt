package com.adrian.commons.interactors.usecases

import com.adrian.commons.interactors.executor.PostExecutionThread
import com.example.commons.usecase.domain.executor.ThreadExecutor
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers


abstract class SingleUseCase<Params, T>(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
): UseCase<Params, Single<T>>() {

    fun execute(params: Params? = null): Single<T> {
        return buildUseCase(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.getScheduler())
    }
}