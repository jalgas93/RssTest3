package com.example.rsstest3.presentations.firstFrontFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.rsstest3.R
import com.example.rsstest3.RssViewModel.FrontViewModel
import com.example.rsstest3.databinding.FragmentAddChannelBinding
import com.example.rsstest3.databinding.ItemAddChannelBinding
import com.example.rsstest3.model.Channel
import com.example.rsstest3.presentations.floatingActionbutton.AddRssFactory
import com.example.rsstest3.repository.Repository


class AddChannelFragment : Fragment() {

    private var _binding: FragmentAddChannelBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mAdapter: AddChannelAdapter
    private val args: AddChannelFragmentArgs by navArgs()

    private lateinit var mViewModel: FrontViewModel
    private lateinit var mFactory: AddChannelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddChannelBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initialiation()
        Log.i("url", args.url.toString())

        mAdapter = AddChannelAdapter()
        mBinding.recyclerViewAddChannel.adapter = mAdapter
        mBinding.flBtnAddChannel.setOnClickListener {
            findNavController().navigate(R.id.action_addChannelFragment_to_addRssFragment)
        }

          mAdapter.setItemAddChannel {
            var a = it.link
            Log.i("link",a.toString())
            var action = AddChannelFragmentDirections.actionAddChannelFragmentToFrontFragment(a!!)
            Navigation.findNavController(view).navigate(action)
        }
    }

    private fun init() {
        var repository = Repository()
        mFactory = AddChannelFactory(repository)
        mViewModel = ViewModelProvider(this, mFactory).get(FrontViewModel::class.java)
        mViewModel.getUrl()
    }

    private fun initialiation() {
        mViewModel.rssChannelGetUrl.observe(viewLifecycleOwner, Observer {
            mAdapter.model = it
        })
    }
}