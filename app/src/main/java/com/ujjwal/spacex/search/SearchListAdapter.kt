package com.ujjwal.spacex.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.recyclerview.widget.RecyclerView
import com.ujjwal.spacex.databinding.LaunchItemBinding
import com.ujjwal.spacex.databinding.SearchItemBinding
import com.ujjwal.spacex.home.callBacks.HomeClickCallback
import com.ujjwal.spacex.home.models.SpaceX
import com.ujjwal.spacex.search.callBacks.SearchClickCallback

class SearchListAdapter(
      private val launchList: List<SpaceX>,
      private val callBacks: SearchClickCallback
): RecyclerView.Adapter<SaerchViewHolder>()  {
    private lateinit var binding: SearchItemBinding




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaerchViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        binding = SearchItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SaerchViewHolder(binding)
    }


    // binds the list items to a view
    override fun onBindViewHolder(holder: SaerchViewHolder, position: Int) {
        val itemsView = launchList[position]
        holder.bind(itemsView,callBacks)
        setFadeAnimation(holder.itemView)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return launchList.size
    }
    fun setFadeAnimation(view: View) {
        val anim = AlphaAnimation(0.5f, 1.0f)
        anim.duration = 300
        view.startAnimation(anim)
    }

}
// Holds the views for adding it to image and text
class SaerchViewHolder(private val binding: SearchItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(productItem: SpaceX, callBacks: SearchClickCallback){
        binding.item = productItem
        binding.callBacks = callBacks
        binding.executePendingBindings()
    }
}



