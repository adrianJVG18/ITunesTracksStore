package com.adrian.itunesstore.ui.manager

import android.content.res.Resources
import com.adrian.itunesstore.R

class TrackStoreResourcesManager(
    private val resources: Resources
): TrackStoreResources {

    override fun getSearchBarHintText(): String =
        resources.getString(R.string.tracks_store_search_bar_hint)


}