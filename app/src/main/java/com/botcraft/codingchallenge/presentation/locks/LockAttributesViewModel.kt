package com.botcraft.codingchallenge.presentation.locks

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.botcraft.codingchallenge.domain.model.ApiError
import com.botcraft.codingchallenge.domain.model.LockDetails
import com.botcraft.codingchallenge.domain.usecase.GetLocksUseCase
import com.botcraft.codingchallenge.domain.usecase.base.UseCaseResponse
import kotlinx.coroutines.cancel


class LockAttributesViewModel constructor(private val getLocksUseCase: GetLocksUseCase) :
    ViewModel() {

    val locksData = MutableLiveData<LockDetails>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun getPosts() {
        showProgressbar.value = true
        getLocksUseCase.invoke(
            viewModelScope, null,
            object : UseCaseResponse<LockDetails> {
                override fun onSuccess(result: LockDetails) {
                    Log.i(TAG, "result: $result")
                    locksData.value = result
                    showProgressbar.value = false
                }

                override fun onError(apiError: ApiError?) {
                    messageData.value = apiError?.getErrorMessage()
                    showProgressbar.value = false
                }
            },
        )
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }

    companion object {
        private val TAG = LockAttributesViewModel::class.java.name
    }

}