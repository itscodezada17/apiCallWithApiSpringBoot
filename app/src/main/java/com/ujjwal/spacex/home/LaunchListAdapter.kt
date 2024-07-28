package com.ujjwal.spacex.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.recyclerview.widget.RecyclerView
import com.ujjwal.spacex.databinding.LaunchItemBinding
import com.ujjwal.spacex.home.callBacks.HomeClickCallback
import com.ujjwal.spacex.home.models.SpaceX


class LaunchListAdapter(
      private val launchList: List<SpaceX>,
      private val callBacks: HomeClickCallback
): RecyclerView.Adapter<HomeViewHolder>()  {
    private lateinit var binding: LaunchItemBinding




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        binding = LaunchItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HomeViewHolder(binding)
    }


    // binds the list items to a view
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val itemsView = launchList[position]
        holder.bind(itemsView,callBacks)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return launchList.size
    }

}
// Holds the views for adding it to image and text
class HomeViewHolder(private val binding: LaunchItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(productItem: SpaceX, callBacks: HomeClickCallback){
        binding.item = productItem
        binding.callBacks = callBacks
        binding.executePendingBindings()
    }
}



