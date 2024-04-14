package com.botcraft.codingchallenge.data.repository

import com.botcraft.codingchallenge.data.source.remote.ApiService
import com.botcraft.codingchallenge.domain.model.LockDetails
import com.botcraft.codingchallenge.domain.repository.LocksRepository


class LocksRepositoryImp(private val apiService: ApiService) : LocksRepository {

    override suspend fun getLockDetails(): LockDetails {
        return apiService.getLockDetails()
    }
}