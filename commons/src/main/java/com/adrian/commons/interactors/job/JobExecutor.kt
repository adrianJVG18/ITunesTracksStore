package com.example.commons.usecase.data.job

import com.example.commons.usecase.domain.executor.ThreadExecutor
import java.util.concurrent.*

class JobExecutor: ThreadExecutor {

    companion object {
        private const val MAXIMUM_POOL_SIZE = 10
    }
    
    private val threadPoolExecutor by lazy {
        Executors.newFixedThreadPool(MAXIMUM_POOL_SIZE)
    }

    override fun execute(command: Runnable?) {
        threadPoolExecutor.execute(command)
    }
}