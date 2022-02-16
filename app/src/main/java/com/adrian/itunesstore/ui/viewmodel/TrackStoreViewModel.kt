package com.adrian.itunesstore.ui.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.adrian.core.domain.model.dto.request.TrackRqDto
import com.adrian.itunesstore.ui.base.BaseViewModel
import com.adrian.itunesstore.ui.manager.TrackStoreResources
import com.adrian.itunesstore.ui.models.SearchBarUI
import com.adrian.itunesstore.ui.models.TrackItemUI
import com.adrian.itunesstore.ui.viewmodel.provider.TrackStoreInteractorsProvider
import io.reactivex.internal.disposables.DisposableContainer

class TrackStoreViewModel(
    disposableContainer: DisposableContainer,
    resources: TrackStoreResources,
    private val owner: LifecycleOwner,
    private val interactors: TrackStoreInteractorsProvider
) : BaseViewModel(disposableContainer) {

    private var currentTerm: String = ""

    val searchUI = SearchBarUI().apply {
        hint = resources.getSearchBarHintText()
    }

    val tracks = MutableLiveData<List<TrackItemUI>>()

    val nowPlaying = MutableLiveData<TrackItemUI>(null)

    init {
        searchUI.input.observe(owner) { term ->
            if (term != currentTerm && term.length > 3) {
                val request = TrackRqDto(term)
                addDisposable(
                    interactors.searchTracksUseCase.execute(request)
                        .map { trackListRsDto ->
                            trackListRsDto.map { track ->
                                TrackItemUI(
                                    track.trackName,
                                    track.artistName,
                                    track.trackViewUrl,
                                    track.previewUrl
                                )
                            }
                        }.subscribe({
                            tracks.value = it
                        }, {

                        })
                )
            }
        }
    }

    fun playTrack(track: TrackItemUI) {
        // TODO handle a nowPlaying track
        nowPlaying.value = track
    }
}