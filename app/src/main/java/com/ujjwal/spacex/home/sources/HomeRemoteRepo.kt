package com.ujjwal.spacex.home.sources


import com.ujjwal.spacex.home.models.SpaceX
import com.ujjwal.spacex.utilities.CONSTANTS
import retrofit2.Retrofit
import retrofit2.http.GET
import timber.log.Timber
import javax.inject.Inject


class HomeRemoteRepo @Inject constructor(
    retrofit: Retrofit
){
    val service = retrofit.create(ApiRequest::class.java)

   suspend fun getLaunchList(): Result<List<SpaceX>> {
        return try {
            val response = service.getLaunchList()
            Result.success(response)
        } catch (e: Exception) {
            Timber.e(e.toString())
            Result.failure(e)
        }
    }

    interface ApiRequest {
        @GET(CONSTANTS.LAUNCHES_LIST)
        suspend fun getLaunchList(): List<SpaceX>
    }

}


