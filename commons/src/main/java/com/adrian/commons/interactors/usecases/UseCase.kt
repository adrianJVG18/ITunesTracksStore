package com.adrian.commons.interactors.usecases

import io.reactivex.disposables.Disposable

abstract class UseCase<Params, R> {

    private var disposable: Disposable? = null

    protected abstract fun buildUseCase(params: Params? = null): R

    fun dispose() {
        disposable?.let {
            if (!it.isDisposed) {
                it.dispose()
            }
        }
    }
}