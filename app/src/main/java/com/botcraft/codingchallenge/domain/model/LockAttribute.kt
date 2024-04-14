package com.botcraft.codingchallenge.domain.model

interface LockAttribute
   {
     val type: Int

    companion object {
        const val TYPE_LOCK_VOLTAGE = 101
        const val TYPE_LOCK_TYPE = 102
        const val TYPE_LOCK_KICK = 103
        const val TYPE_LOCK_RELEASE = 104
        const val TYPE_LOCK_RELEASE_TIME = 105
        const val TYPE_LOCK_ANGLE = 106
    }
}