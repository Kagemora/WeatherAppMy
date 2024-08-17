package com.example.weatherappmy.presentation.favorites

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.weatherappmy.App
import com.example.weatherappmy.databinding.FragmentFavouritesCityBinding
import com.example.weatherappmy.presentation.ViewModelFactory
import javax.inject.Inject

class FavouritesCityFragment : Fragment() {

    private var _binding: FragmentFavouritesCityBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: FavouritesCityViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val component by lazy {
        (requireActivity().application as App).appComponent
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouritesCityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[FavouritesCityViewModel::class.java]

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = FavouritesCityFragment()
    }
}