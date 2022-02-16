package com.example.commons.usecase.data.job

import com.adrian.commons.interactors.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class UIThread: PostExecutionThread {
    override fun getScheduler(): Scheduler = AndroidSchedulers.mainThread()
}