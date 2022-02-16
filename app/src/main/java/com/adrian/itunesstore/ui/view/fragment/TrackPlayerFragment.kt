package com.adrian.itunesstore.ui.view.fragment

import com.adrian.itunesstore.R
import com.adrian.itunesstore.databinding.FragmentTrackPlayerBinding
import com.adrian.itunesstore.ui.base.BaseFragment
import com.adrian.itunesstore.ui.viewmodel.TrackStoreViewModel
import com.adrian.itunesstore.utils.extensions.viewBinding

class TrackPlayerFragment(
    override val viewModel: TrackStoreViewModel
) : BaseFragment<FragmentTrackPlayerBinding, TrackStoreViewModel>(
    R.layout.fragment_track_player
) {
    override val binding: FragmentTrackPlayerBinding by viewBinding(FragmentTrackPlayerBinding::bind)

    override fun setUpViews() {
        binding.quitTrackButton.setOnClickListener {
            // TODO handle clear track player
            viewModel.nowPlaying.value = null
        }
    }
}