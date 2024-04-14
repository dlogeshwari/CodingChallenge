package com.botcraft.codingchallenge.domain.repository

import com.botcraft.codingchallenge.domain.model.LockDetails


interface LocksRepository {

    suspend fun getLockDetails(): LockDetails
}