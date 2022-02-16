package com.adrian.itunesstore.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import io.reactivex.internal.disposables.DisposableContainer


abstract class BaseViewModel(private val disposableContainer: DisposableContainer): ViewModel() {
    fun addDisposable(disposable: Disposable) {
        disposableContainer.add(disposable)
    }
}