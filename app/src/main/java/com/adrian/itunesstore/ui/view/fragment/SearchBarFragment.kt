package com.adrian.itunesstore.ui.view.fragment

import com.adrian.itunesstore.R
import com.adrian.itunesstore.databinding.FragmentSearchBarBinding
import com.adrian.itunesstore.ui.base.BaseFragment
import com.adrian.itunesstore.ui.viewmodel.TrackStoreViewModel
import com.adrian.itunesstore.utils.extensions.viewBinding

class SearchBarFragment(
    override val viewModel: TrackStoreViewModel
) : BaseFragment<FragmentSearchBarBinding, TrackStoreViewModel>(R.layout.fragment_search_bar) {

    override val binding: FragmentSearchBarBinding by viewBinding(FragmentSearchBarBinding::bind)

    override fun setUpViews() {
        binding.search = viewModel.searchUI
    }

}