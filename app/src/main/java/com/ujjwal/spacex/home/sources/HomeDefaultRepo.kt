package com.ujjwal.spacex.home.sources

import com.ujjwal.spacex.home.models.SpaceX
import javax.inject.Inject

class HomeDefaultRepo @Inject constructor(
    val remoteRepo: HomeRemoteRepo
): HomeDataSource {
    override suspend fun getLauncheList(): Result<List<SpaceX>> {
        return remoteRepo.getLaunchList()
    }
}