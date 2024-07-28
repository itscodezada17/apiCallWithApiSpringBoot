package com.ujjwal.spacex.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.ujjwal.spacex.databinding.FragmentHomeBinding
import com.ujjwal.spacex.home.callBacks.HomeClickCallback
import com.ujjwal.spacex.home.models.SpaceX
import com.ujjwal.spacex.utilities.EventObserver
import com.ujjwal.spacex.utilities.navigate
import com.ujjwal.spacex.utilities.navigateBack
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    val binding get() = _binding

    val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false )
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setNavigationButton()
        setBackListener()
        setObservers()
    }

    private fun setRecyclerView(sneakersList: List<SpaceX>) {
        binding.pb.visibility = View.GONE
        val callBacks =  HomeClickCallback(homeViewModel)
        binding.rv.adapter = LaunchListAdapter(sneakersList,callBacks)
        binding.rv.layoutManager = GridLayoutManager(this.context,2)
        binding.rv.setHasFixedSize(true)
    }

    private fun setNavigationButton() {
        binding.tabLayout.setNavigationOnClickListener { navigateBack() }
    }


    private val backPressedCallback: OnBackPressedCallback =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navigateBack()
            }
        }

    private fun setBackListener() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            backPressedCallback
        )
    }


    private fun setObservers() {
        homeViewModel.navDirections.observe(viewLifecycleOwner, EventObserver{
            navigate(it)
        })
        homeViewModel.launchListLiveData.observe(viewLifecycleOwner) {
            setRecyclerView(it)
        }

    }


}

