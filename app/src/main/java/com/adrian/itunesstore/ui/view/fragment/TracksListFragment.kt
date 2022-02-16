package com.adrian.itunesstore.ui.view.fragment

import android.view.View
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrian.itunesstore.R
import com.adrian.itunesstore.databinding.FragmentTrackListBinding
import com.adrian.itunesstore.ui.adapter.TracksAdapter
import com.adrian.itunesstore.ui.base.BaseFragment
import com.adrian.itunesstore.ui.base.BaseViewModel
import com.adrian.itunesstore.ui.viewmodel.TrackStoreViewModel
import com.adrian.itunesstore.utils.extensions.viewBinding

class TracksListFragment(
    override val viewModel: TrackStoreViewModel
): BaseFragment<FragmentTrackListBinding, BaseViewModel>(
    R.layout.fragment_track_list
) {
    override val binding: FragmentTrackListBinding by viewBinding(FragmentTrackListBinding::bind)

    private val tracksAdapter: TracksAdapter by lazy {
        TracksAdapter(viewModel.tracks, context as LifecycleOwner, viewModel::playTrack)
    }

    override fun setUpViews() {
        binding.trackListRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.trackListRecyclerView.adapter = tracksAdapter
    }

    override fun observeData() {
        viewModel.tracks.observe(this) { trackList ->
            handleEmptyState(trackList.isNullOrEmpty())
        }
    }

    private fun handleEmptyState(isEmpty: Boolean) {
        binding.trackListRecyclerView.visibility = if (isEmpty) View.GONE else View.VISIBLE
        binding.emptyStateGroup.visibility = if (isEmpty) View.VISIBLE else View.GONE
    }


}