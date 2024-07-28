package com.ujjwal.spacex.home.sources

import com.ujjwal.spacex.home.models.SpaceX

interface HomeDataSource {
    suspend fun getLauncheList(): Result<List<SpaceX>>
}
