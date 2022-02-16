package com.adrian.commons.interactors.executor

import io.reactivex.Scheduler


interface PostExecutionThread {
    fun getScheduler(): Scheduler
}