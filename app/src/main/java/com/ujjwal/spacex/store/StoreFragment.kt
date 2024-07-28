package com.ujjwal.spacex.store

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import com.ujjwal.spacex.databinding.FragmentStoreBinding
import com.ujjwal.spacex.utilities.navigateBack
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class StoreFragment : Fragment() {
    private lateinit var _binding: FragmentStoreBinding
    val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         _binding = FragmentStoreBinding.inflate(inflater, container, false )
        Timber.d("LifeCycle Method: OnCreateView")
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Timber.d("LifeCycle Method: OnViewCreated")
        setBackListener()
        setWebView()
    }

    private fun setWebView() {
        // loading http://www.google.com url in the WebView.
        binding.wv.loadUrl("https://www.spacex.com/vehicles/falcon-9/")

        // this will enable the javascript.
        binding.wv.settings.javaScriptEnabled = true

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        binding.wv.setWebViewClient(
            object : WebViewClient(){
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    binding.pb.visibility = View.VISIBLE
                }
                override fun onPageFinished(view: WebView, url: String) {
                    super.onPageFinished(view, url)
                    binding.pb.visibility = View.GONE
                }

        })
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