package com.example.rsstest3.presentations.frontFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.rsstest3.R
import com.example.rsstest3.RssViewModel.FrontViewModel
import com.example.rsstest3.databinding.FragmentFrontBinding


class FrontFragment : Fragment() {

    private var _binding: FragmentFrontBinding? = null
    private val mBinding get() = _binding!!
    private val viewModel: FrontViewModel by viewModels()
    private lateinit var adapter: FrontAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentFrontBinding.inflate(layoutInflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FrontAdapter()
        _binding?.recyclerView?.adapter = adapter
        startFunction()
        viewModel.a()

    }

    private fun startFunction() {

        val adapter = FrontAdapter()
       _binding?.recyclerView?.adapter = adapter
        viewModel.liveData.observe(viewLifecycleOwner, Observer {
           adapter.model = it
            Log.i("Ruslan",it.toString())
        })



    }

}