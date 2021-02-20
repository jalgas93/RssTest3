package com.example.rsstest3.presentations.backFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs

import com.example.rsstest3.R
import com.example.rsstest3.databinding.FragmentBackBinding

class BackFragment : Fragment() {

     var _binding: FragmentBackBinding? = null
    private val mBinding get() = _binding!!
    private val args: BackFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBackBinding.inflate(layoutInflater, container, false)
        return mBinding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.webView.apply {
            webViewClient = WebViewClient()
            Log.i("jalgas4",args.url.toString())
            args.url?.let { loadUrl(it) }
        }
    }
    }
