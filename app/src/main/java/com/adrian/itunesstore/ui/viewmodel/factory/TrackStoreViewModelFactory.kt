package com.adrian.itunesstore.ui.viewmodel.factory

import android.content.res.Resources
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adrian.itunesstore.ui.manager.TrackStoreResources
import com.adrian.itunesstore.ui.manager.TrackStoreResourcesManager
import com.adrian.itunesstore.ui.viewmodel.TrackStoreViewModel
import com.adrian.itunesstore.ui.viewmodel.provider.TrackStoreInteractorsProvider
import io.reactivex.disposables.CompositeDisposable
import java.lang.IllegalArgumentException

class TrackStoreViewModelFactory(
    private val compositeDisposable: CompositeDisposable,
    private val resources: Resources,
    private val owner: LifecycleOwner
): ViewModelProvider.Factory {

    private val trackStoreResources: TrackStoreResources by lazy {
        TrackStoreResourcesManager(resources)
    }

    private val interactors: TrackStoreInteractorsProvider by lazy {
        TrackStoreInteractorsProvider()
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(TrackStoreViewModel::class.java)) {
            TrackStoreViewModel(compositeDisposable, trackStoreResources, owner, interactors) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}