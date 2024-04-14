package com.botcraft.codingchallenge.domain.usecase

import com.botcraft.codingchallenge.domain.model.LockDetails
import com.botcraft.codingchallenge.domain.repository.LocksRepository
import com.botcraft.codingchallenge.domain.usecase.base.UseCase

class GetLocksUseCase constructor(
    private val locksRepository: LocksRepository
) : UseCase<LockDetails, Any?>() {

    override suspend fun run(params: Any?): LockDetails {
        return locksRepository.getLockDetails()
    }

}