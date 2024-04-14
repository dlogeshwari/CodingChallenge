package com.botcraft.codingchallenge.domain.usecase.base

import com.botcraft.codingchallenge.domain.model.ApiError


interface UseCaseResponse<Type> {

    fun onSuccess(result: Type)

    fun onError(apiError: ApiError?)
}

