package com.example.weatherappmy.presentation.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.weatherappmy.App
import com.example.weatherappmy.databinding.FragmentSearchCityBinding
import com.example.weatherappmy.presentation.ViewModelFactory
import com.example.weatherappmy.presentation.search.adapter.CitySearchListAdapter
import javax.inject.Inject

class SearchCityFragment : Fragment() {
    private var _binding: FragmentSearchCityBinding? = null
    private val binding get() = _binding!!

    private val component by lazy {
        (requireActivity().application as App).appComponent
    }
    private lateinit var adapter: CitySearchListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: SearchCityViewModel


    companion object {
        private const val CITY_ADD = "CITY_ADD"
        private const val CITI_ADD_TRUE = true
        private const val SEARCH_CITY = "SEARCH_CITY"
        private const val SEARCH_CITY_FALSE = false

        fun newInstanceAddCity(): SearchCityFragment {
            return SearchCityFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(CITY_ADD, CITI_ADD_TRUE)
                }
            }
        }

        fun newInstanceSearchCity(): SearchCityFragment {
            return SearchCityFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(SEARCH_CITY, SEARCH_CITY_FALSE)
                }
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchCityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        installAdapter()
        viewModel = ViewModelProvider(this, viewModelFactory)[SearchCityViewModel::class.java]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.recyclerView.adapter = null
        adapter.onClickCity = null
        _binding = null
    }

    private fun installAdapter() {
        adapter = CitySearchListAdapter()
        binding.recyclerView.adapter = adapter
        setupClickListenerViewHolder()
    }

    private fun setupClickListenerViewHolder() {
        adapter.onClickCity = {

        }
    }

}