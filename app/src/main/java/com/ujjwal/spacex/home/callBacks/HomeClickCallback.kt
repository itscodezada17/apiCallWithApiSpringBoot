package com.ujjwal.spacex.home.callBacks

import com.ujjwal.spacex.home.HomeFragmentDirections
import com.ujjwal.spacex.home.HomeViewModel
import com.ujjwal.spacex.home.models.SpaceX

class HomeClickCallback constructor(
    private val homeViewModel: HomeViewModel
) {

    fun navigateToProductDetailFragment(product: SpaceX){
        val directions =
            HomeFragmentDirections.actionHomeFragmentToProductDetailFragment(product)
        homeViewModel.updateDirections(directions)
    }

}