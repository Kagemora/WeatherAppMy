package com.example.weatherappmy.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherappmy.App
import com.example.weatherappmy.databinding.FragmentSearchCityBinding

class SearchCityFragment : Fragment() {
    private var _binding: FragmentSearchCityBinding? = null
    private val binding get() = _binding!!

    private val component by lazy {
        (requireActivity().application as App).appComponent
    }
    companion object {
        fun newInstance() = SearchCityFragment()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchCityBinding.inflate(inflater,container,false)
        return binding.root
    }
}