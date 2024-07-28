package com.ujjwal.spacex.productDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.navArgs
import com.ujjwal.spacex.databinding.FragmentProductDetailBinding
import com.ujjwal.spacex.home.models.SpaceX
import com.ujjwal.spacex.utilities.navigateBack
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {

    private lateinit var _binding: FragmentProductDetailBinding
    val binding get() = _binding


    private val args: ProductDetailsFragmentArgs by navArgs()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false )
        _binding.lifecycleOwner = viewLifecycleOwner
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setBackListener()
        setUi(args.product)
    }

    private fun setUi(spaceX: SpaceX) {
        _binding.item = spaceX
        _binding.basicDetails.item = spaceX
        _binding.mediaLinks.item = spaceX
        _binding.rocketDetails.item = spaceX
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
}