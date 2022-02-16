package com.adrian.itunesstore.ui.models

data class TrackItemUI(
    val title: String,
    val artist: String,
    val iconUri: String? = null,
    val trackUri: String
)