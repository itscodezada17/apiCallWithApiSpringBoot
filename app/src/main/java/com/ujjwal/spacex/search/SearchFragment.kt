package com.ujjwal.spacex.search


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.ujjwal.spacex.databinding.FragmentSearchBinding
import com.ujjwal.spacex.home.models.SpaceX
import com.ujjwal.spacex.search.callBacks.SearchClickCallback
import com.ujjwal.spacex.utilities.EventObserver
import com.ujjwal.spacex.utilities.navigate
import com.ujjwal.spacex.utilities.navigateBack
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var _binding: FragmentSearchBinding
    val binding get() = _binding

    val searchViewModel: SearchViewModel by viewModels()
    lateinit var list: List<SpaceX>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false )
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setSearchClickListener()
        setBackListener()
        setObservers()
    }

    override fun onResume() {
        super.onResume()
        if(!binding.edtxt.text.isNullOrEmpty()){
            val filteredList: MutableList<SpaceX> = getFilteredList(list, binding.edtxt.text.toString())
            setRecyclerView(filteredList)
        }
    }

    private fun setSearchClickListener() {
        binding.searchBtn.setOnClickListener {
            if(binding.edtxt.text.isNullOrEmpty()){
                Toast.makeText(requireActivity(), "Please write something in the search bar to search!", Toast.LENGTH_SHORT).show()
            }else{
                val filteredList: MutableList<SpaceX> = getFilteredList(list, binding.edtxt.text.toString())
                setRecyclerView(filteredList)
            }
        }

    }

    private fun getFilteredList(list: List<SpaceX>, searchText: String): MutableList<SpaceX> {
        var filteredList = mutableListOf<SpaceX>()
        val search = searchText.uppercase()
        for (item in list){
            if(item.launchYear==searchText)
                filteredList.add(item)
            else if (item.missionName?.uppercase()?.contains(search) == true)
                filteredList.add(item)
            else if (item.rocket?.rocketName?.uppercase()?.contains(search) == true)
                filteredList.add(item)
        }
        return filteredList
    }

    private fun setRecyclerView(lauchList: List<SpaceX>) {
        if(lauchList.isNotEmpty()){
            binding.noItem.visibility = View.GONE
            binding.rv.visibility = View.VISIBLE
            val callBacks =  SearchClickCallback(searchViewModel)
            binding.rv.adapter = SearchListAdapter(lauchList,callBacks)
            binding.rv.layoutManager = GridLayoutManager(this.context,2)
            binding.rv.setHasFixedSize(true)
        }else{
            binding.noItem.visibility = View.VISIBLE
            binding.rv.visibility = View.GONE
        }

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
        searchViewModel.navDirections.observe(viewLifecycleOwner, EventObserver{
            navigate(it)
        })
        searchViewModel.launchListLiveData.observe(viewLifecycleOwner) {
            list = it
            binding.pb.visibility = View.GONE
        }

    }


}

