package com.adrian.itunesstore.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.adrian.itunesstore.databinding.ItemTrackBinding
import com.adrian.itunesstore.ui.models.TrackItemUI

@SuppressLint("NotifyDataSetChanged")
class TracksAdapter(
    tracks: MutableLiveData<List<TrackItemUI>>,
    owner: LifecycleOwner,
    private val playAction: (TrackItemUI) -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var trackList: List<TrackItemUI> = ArrayList()

    init {
        tracks.observe(owner) {
            trackList = it
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemTrackBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrackViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TrackViewHolder).bind(trackList[position])
    }

    override fun getItemCount(): Int = trackList.size

    private inner class TrackViewHolder(
        private val binding: ItemTrackBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TrackItemUI) {
            binding.track = item
            binding.trackIconImageView.setOnClickListener {
                playAction.invoke(item)
            }
        }
    }
}