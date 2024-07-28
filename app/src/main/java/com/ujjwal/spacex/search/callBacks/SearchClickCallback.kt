package com.ujjwal.spacex.search.callBacks

import com.ujjwal.spacex.home.models.SpaceX
import com.ujjwal.spacex.search.SearchFragmentDirections
import com.ujjwal.spacex.search.SearchViewModel

class SearchClickCallback constructor(
    private val searchViewModel: SearchViewModel
) {

    fun navigateToProductDetailFragment(product: SpaceX){
        val directions =
            SearchFragmentDirections.actionSearchFragmentToProductDetailFragment(product)
        searchViewModel.updateDirections(directions)
    }

}