package com.example.rsstest3.presentations.frontFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.rsstest3.R
import com.example.rsstest3.RssViewModel.FrontViewModel
import com.example.rsstest3.databinding.FragmentFrontBinding
import com.example.rsstest3.model.Channel
import com.example.rsstest3.repository.Repository


class FrontFragment : Fragment() {

    private var _binding: FragmentFrontBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var adapter: FrontAdapter
    private val args: FrontFragmentArgs by navArgs()
    private lateinit var mViewModel: FrontViewModel
    private lateinit var mFactory:FrontViewModelFactory



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
        mViewModel.initialUrl(args.webUrl)
        startFunction()


        adapter.setItemClick {
            var a = it.link
//            var b = it.author
//            var s = it.categories
//            var d = it.content
//            var e = it.description
//            var f = it.guid
//            var j = it.image
//            var i = it.link
//            var g = it.pubDate
//            var h = it.sourceName
//            var u = it.sourceUrl
//            var o = it.title
//            var p = it.video


           var action = FrontFragmentDirections.actionFrontFragmentToBackFragment(a)
            Navigation.findNavController(view).navigate(action)
           // Navigation.findNavController(view).navigate(R.id.action_frontFragment_to_backFragment)
            Toast.makeText(requireContext(), "1", Toast.LENGTH_LONG).show()
        }


    }

    private fun init() {
        var repository = Repository()
        mViewModel = ViewModelProvider(this,mFactory).get(FrontViewModel::class.java)
    }

    private fun startFunction() {
//        val adapter = FrontAdapter()
        _binding?.recyclerView?.adapter = adapter
        mViewModel.liveData.observe(viewLifecycleOwner, Observer {

        // adapter.model = it.articles
            Log.i("Ruslan", it.toString())
        })


    }

}