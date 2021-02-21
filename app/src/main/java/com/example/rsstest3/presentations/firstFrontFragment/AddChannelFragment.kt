package com.example.rsstest3.presentations.firstFrontFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.rsstest3.R
import com.example.rsstest3.AllViewModel.AllViewModel
import com.example.rsstest3.databinding.FragmentAddChannelBinding
import com.example.rsstest3.repository.Repository


class AddChannelFragment : Fragment() {

    private var _binding: FragmentAddChannelBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mAdapter: AddChannelAdapter
    private val args: AddChannelFragmentArgs by navArgs()
    private lateinit var mViewModel: AllViewModel
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
        Log.i("jalgas7", args.url.toString())
        mViewModel.getUrlAddress()
        mAdapter = AddChannelAdapter()
        mBinding.recyclerViewAddChannel.adapter = mAdapter
        mBinding.flBtnAddChannel.setOnClickListener {
            findNavController().navigate(R.id.action_addChannelFragment_to_addRssFragment)
        }
        mViewModel.getUrlAddress()
        getUrl()


        mAdapter.setDeleteItem {
            var a = it.link
            var b = it.articles
            var s = it.description
           // var d = it.id
            var e = it.image
            var j = it.lastBuildDate
            var q = it.title
            var w = it.updatePeriod

            val dialog: AlertDialog = AlertDialog.Builder(requireContext())
                .setMessage("Вы уверены что хотите удалить ? ")
                .setTitle("Удалить")
                .setPositiveButton("yes") { _, _ ->
//                    mViewModel.deleteItem(
//                        Channel(d, q, a,s,e,j,w,b)
//                    )
                   // mViewModel.getUrl()
                }
                .setNegativeButton("no", null)
                .create()
            dialog.show()
        }
          mAdapter.setItemAddChannel {
            var a = it.link
            Log.i("jalgas6",a.toString())
            var action = AddChannelFragmentDirections.actionAddChannelFragmentToFrontFragment(a!!)
            Navigation.findNavController(view).navigate(action)
        }
    }

    private fun getUrl() {
        mViewModel.getUrlAddressLiveData.observe(viewLifecycleOwner, Observer {
//          mViewModel.ChannelFunction(it.urlAddres)
         //   Log.i("jalgas11",it.toString())
        })
    }

    private fun init() {
        var repository = Repository()
        mFactory = AddChannelFactory(repository)
        mViewModel = ViewModelProvider(this, mFactory).get(AllViewModel::class.java)

    }
    private fun initialiation() {
        mViewModel.channelLiveData.observe(viewLifecycleOwner, Observer {
            mAdapter.model = it
        })
    }
}