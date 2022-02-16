package com.adrian.itunesstore.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity<Binding: ViewBinding, ViewModel: BaseViewModel>: AppCompatActivity() {

    protected abstract val binding: Binding
    protected abstract val viewModel: ViewModel

    protected val disposableContainer = CompositeDisposable()

    open fun initFragments() {}
    open fun setUpViews() {}
    open fun observeData() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initFragments()
        setUpViews()
        observeData()
    }

    override fun onDestroy() {
        disposableContainer.clear()
        super.onDestroy()
    }
}