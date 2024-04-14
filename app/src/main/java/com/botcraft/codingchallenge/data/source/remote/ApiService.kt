package com.botcraft.codingchallenge.data.source.remote

import com.botcraft.codingchallenge.domain.model.LockDetails
import retrofit2.http.GET


interface ApiService {

    @GET("v3/d5f5d613-474b-49c4-a7b0-7730e8f8f486")
    suspend fun getLockDetails(): LockDetails
}