package com.movie.bestrelases.util

import io.reactivex.Scheduler


interface SchedulerProvider {

    fun ui(): Scheduler

    fun computation(): Scheduler

    fun io(): Scheduler

}