package com.adrian.itunesstore.ui.models

import androidx.lifecycle.MutableLiveData

class SearchBarUI {
    val input = MutableLiveData<String>()
    var hint: String = ""
}