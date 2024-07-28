package com.ujjwal.spacex.utilities

class CONSTANTS {
    companion object{
        private const val SPACEX_BASE_URL = "https://api.spacexdata.com/v3/"

        const val LAUNCHES_LIST = SPACEX_BASE_URL +  "launches"

        const val PRODUCT_DETAIL = "$LAUNCHES_LIST/{product_id}"

        const val PRODUCT_CART = LAUNCHES_LIST +  "carts/1"


        const val QUERY_PRODUCT_ID = "product_id"
    }
}