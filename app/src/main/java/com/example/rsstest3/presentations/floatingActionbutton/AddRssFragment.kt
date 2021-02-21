package com.example.rsstest3.presentations.floatingActionbutton

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.rsstest3.R
import com.example.rsstest3.AllViewModel.AllViewModel
import com.example.rsstest3.databinding.FragmentAddRssBinding
import com.example.rsstest3.model.UrlAddress
import com.example.rsstest3.repository.Repository


class AddRssFragment : Fragment() {

    private var binding: FragmentAddRssBinding? = null
    private val mBinding get() = binding!!
    private val args: AddRssFragmentArgs by navArgs()
    private lateinit var mViewModel: AllViewModel
    private lateinit var frontViewModelFactory: AddRssFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddRssBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        mBinding.btnAddRss.setOnClickListener {
            initialization()
        }
    }

    private fun initialization() {
        var text = mBinding.etAddRss.text.toString().trim()
        Log.i("text", text.toString())
        if (text.isNotEmpty()) {
            findNavController().navigate(R.id.action_addRssFragment_to_addChannelFragment)
            mViewModel.insertUrlAddress(
                UrlAddress(urlAddres = text)
            )
        } else {
            Toast.makeText(requireContext(), "Добавьте Rss адрес", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun init() {
        val repository = Repository()
        frontViewModelFactory = AddRssFactory(repository = repository)
        mViewModel = ViewModelProvider(this, frontViewModelFactory).get(AllViewModel::class.java)
    }

}