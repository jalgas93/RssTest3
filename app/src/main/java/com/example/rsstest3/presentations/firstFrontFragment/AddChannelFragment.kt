package com.example.rsstest3.presentations.firstFrontFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.rsstest3.R
import com.example.rsstest3.databinding.FragmentAddChannelBinding


class AddChannelFragment : Fragment() {

    private var _binding: FragmentAddChannelBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mAdapter: AddChannelAdapter


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
        mAdapter = AddChannelAdapter()
        mBinding.recyclerViewAddChannel.adapter = mAdapter
        initialiation()

        mAdapter.setItemAddChannel {
            var a = it.link
            var action = AddChannelFragmentDirections.actionAddChannelFragmentToFrontFragment(a!!)
            Navigation.findNavController(view).navigate(action)

        }
    }

    private fun initialiation() {


    }


}