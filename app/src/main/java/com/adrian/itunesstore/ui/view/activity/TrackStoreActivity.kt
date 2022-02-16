package com.adrian.itunesstore.ui.view.activity

import android.view.View
import androidx.fragment.app.commit
import com.adrian.itunesstore.R
import com.adrian.itunesstore.databinding.ActivityTrackStoreBinding
import com.adrian.itunesstore.ui.base.BaseActivity
import com.adrian.itunesstore.ui.view.fragment.SearchBarFragment
import com.adrian.itunesstore.ui.view.fragment.TrackPlayerFragment
import com.adrian.itunesstore.ui.view.fragment.TracksListFragment
import com.adrian.itunesstore.ui.viewmodel.TrackStoreViewModel
import com.adrian.itunesstore.ui.viewmodel.factory.TrackStoreViewModelFactory
import com.adrian.itunesstore.utils.extensions.viewBinding

class TrackStoreActivity : BaseActivity<ActivityTrackStoreBinding, TrackStoreViewModel>() {

    override val binding: ActivityTrackStoreBinding by viewBinding(ActivityTrackStoreBinding::inflate)
    override val viewModel: TrackStoreViewModel by lazy {
        TrackStoreViewModelFactory(disposableContainer, resources, this).create(TrackStoreViewModel::class.java)
    }

    private val trackListFragment: TracksListFragment by lazy {
        TracksListFragment(viewModel)
    }

    private val searchBarFragment: SearchBarFragment by lazy {
        SearchBarFragment(viewModel)
    }

    private val trackPlayerFragment: TrackPlayerFragment by lazy {
        TrackPlayerFragment(viewModel)
    }

    override fun initFragments() {
        showSearchBarFragment()
        showTrackListFragment()
        setTrackPlayerFragment()
    }

    override fun observeData() {
        viewModel.nowPlaying.observe(this) { track ->
            binding.tracksPlayerFragmentContainerView.visibility =
                if (track != null) View.VISIBLE else View.GONE
        }
    }

    private fun showSearchBarFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.search_bar_fragment_container_view, searchBarFragment)
        }
    }

    private fun showTrackListFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.tracks_list_fragment_container_view, trackListFragment)
        }
    }

    private fun setTrackPlayerFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.tracks_player_fragment_container_view, trackPlayerFragment)
        }
    }
}