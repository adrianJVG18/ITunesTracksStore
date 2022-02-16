package com.adrian.itunesstore.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment<Binding: ViewBinding, ViewModel: BaseViewModel>(
    layoutId: Int
): Fragment(layoutId) {

    protected abstract val binding: Binding
    protected abstract val viewModel: ViewModel

    protected val disposableContainer = CompositeDisposable()

    open fun setUpViews() {}
    open fun observeData() {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        observeData()
    }

    override fun onDestroyView() {
        disposableContainer.clear()
        super.onDestroyView()
    }

}