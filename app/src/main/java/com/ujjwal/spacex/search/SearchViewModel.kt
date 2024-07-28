package com.ujjwal.spacex.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.ujjwal.spacex.home.models.SpaceX
import com.ujjwal.spacex.home.sources.HomeDataSource
import com.ujjwal.spacex.utilities.SingleEvent
import com.ujjwal.spacex.utilities.di.DispatcherModule
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    @DispatcherModule.IoDispatcher val coroutineDispatcher: CoroutineDispatcher,
    var repo: HomeDataSource
): ViewModel() {
    private val _navDirection: MutableLiveData<SingleEvent<NavDirections>> = MutableLiveData()
    val navDirections: LiveData<SingleEvent<NavDirections>> = _navDirection

    private val _launchListLiveData: MutableLiveData<List<SpaceX>> = MutableLiveData()
    val launchListLiveData: LiveData<List<SpaceX>> = _launchListLiveData


    init {
        getLaunchesList()
    }

    private fun getLaunchesList() {
        viewModelScope.launch(coroutineDispatcher) {
            val response = repo.getLauncheList()
            response.onSuccess {
                _launchListLiveData.postValue(it)
            }
            response.onFailure {
                Timber.d("Failed in SearchViewModel $it")
            }
        }
    }


    fun updateDirections(directions: NavDirections){
        _navDirection.postValue(SingleEvent(directions))
    }

}