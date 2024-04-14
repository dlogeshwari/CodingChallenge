package com.botcraft.codingchallenge.di.module

import com.botcraft.codingchallenge.presentation.locks.LockAttributesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val AppModule = module {

    viewModel { LockAttributesViewModel(get()) }

    single { createGetPostsUseCase(get()) }

    single { createPostRepository(get()) }
}