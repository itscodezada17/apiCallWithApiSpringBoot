package com.ujjwal.spacex.home.di

import com.ujjwal.spacex.home.sources.HomeDataSource
import com.ujjwal.spacex.home.sources.HomeDefaultRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class HomeRepoModule {
    @Binds
    @ViewModelScoped
    abstract fun bindHomeRepo(repo: HomeDefaultRepo): HomeDataSource
}