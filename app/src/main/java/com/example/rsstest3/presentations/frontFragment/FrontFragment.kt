package com.example.rsstest3.presentations.frontFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.rsstest3.AllViewModel.AllViewModel
import com.example.rsstest3.databinding.FragmentFrontBinding
import com.example.rsstest3.repository.Repository


class FrontFragment : Fragment() {

    private var _binding: FragmentFrontBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var adapter: FrontAdapter
    private val args: FrontFragmentArgs by navArgs()
    private lateinit var mViewModel: AllViewModel
    private lateinit var mFactory: FrontViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFrontBinding.inflate(layoutInflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        adapter = FrontAdapter()
        _binding?.recyclerView?.adapter = adapter
        Log.i("jalgas9", args.webUrl)
        startFunction()
        getUrl()
        mViewModel.getUrlAddress()



        adapter.setItemClick {
            var a = it.link
            var action = FrontFragmentDirections.actionFrontFragmentToBackFragment(a)
            Navigation.findNavController(view).navigate(action)
        }

        mBinding.ivToolbar.setOnClickListener {
            requireActivity().onBackPressed()
        }

        var tv_toolbar = mBinding.tvToolbar
        //  tv_toolbar.text =
    }

    private fun getUrl() {
        mViewModel.rssChannelGetUrl.observe(viewLifecycleOwner, Observer {
            mViewModel.fetchForUrlAndParseRawData(it.urlAddres)
        })
    }

    private fun init() {
        var repository = Repository()
        mFactory = FrontViewModelFactory(repository)
        mViewModel = ViewModelProvider(this, mFactory).get(AllViewModel::class.java)
    }

    private fun startFunction() {
        _binding?.recyclerView?.adapter = adapter
        mViewModel.liveData.observe(viewLifecycleOwner, Observer {
            adapter.model = it
            Log.i("jalgas8", it.toString())

        })
    }
}