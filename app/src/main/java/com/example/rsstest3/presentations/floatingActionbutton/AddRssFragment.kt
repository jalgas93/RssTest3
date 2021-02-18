package com.example.rsstest3.presentations.floatingActionbutton

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.rsstest3.R
import com.example.rsstest3.databinding.FragmentAddRssBinding


class AddRssFragment : Fragment() {

    private var binding: FragmentAddRssBinding? = null
    private val mBinding get() = binding!!

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

        mBinding.btnAddRss.setOnClickListener {
            initialization()
        }
    }

    private fun initialization() {
        var text = mBinding.etAddRss.text.toString().trim()
        if (text.isNotEmpty()) {

            var action = AddRssFragmentDirections.actionAddRssFragmentToAddChannelFragment(text)
            findNavController().navigate(action)

        } else {
            Toast.makeText(requireContext(), "Добавьте Rss адресс", Toast.LENGTH_SHORT)
                .show()
        }
    }

}