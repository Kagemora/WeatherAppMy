package com.example.weatherappmy.presentation.favorites

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherappmy.App
import com.example.weatherappmy.R
import com.example.weatherappmy.databinding.FragmentFavouritesCityBinding
import com.example.weatherappmy.presentation.ViewModelFactory
import com.example.weatherappmy.presentation.favorites.adapter.CityListAdapter
import com.example.weatherappmy.presentation.favorites.ui.CityWithWeather
import com.example.weatherappmy.presentation.favorites.ui.UiState
import com.example.weatherappmy.presentation.search.SearchCityFragment
import javax.inject.Inject

class FavouritesCityFragment : Fragment() {

    private var _binding: FragmentFavouritesCityBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: FavouritesCityViewModel

    @Inject
    lateinit var cityListAdapter: CityListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val component by lazy {
        (requireActivity().application as App).appComponent
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
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
        setupRecyclerView()
        observeViewModel()
        binding.searchCardView.setOnClickListener{

        }
        binding.extendedFloatingActionButton.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main,SearchCityFragment.newInstance())
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeViewModel() {
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is UiState.Loading -> showLoading()
                is UiState.Success -> showCities(state.cityWithWeather)
                is UiState.Error -> showError(state.error)
                is UiState.Empty -> showEmptyState()
            }
        }
        viewModel.toastMessage.observe(viewLifecycleOwner) { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.GONE
    }

    private fun showCities(cities: List<CityWithWeather>) {
        binding.progressBar.visibility = View.GONE
        binding.recyclerView.visibility = View.VISIBLE
        cityListAdapter.submitList(cities)
    }

    private fun showError(error: String) {
        binding.progressBar.visibility = View.GONE
        binding.recyclerView.visibility = View.VISIBLE
        Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
    }

    private fun showEmptyState() {
        binding.progressBar.visibility = View.GONE
        binding.recyclerView.visibility = View.GONE
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = cityListAdapter
        setupSwipeListener(binding.recyclerView)
        setupClickListener()
    }

    private fun setupSwipeListener(cityC: RecyclerView) {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = cityListAdapter.currentList[viewHolder.adapterPosition]
                viewModel.removeCity(item.city.id)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(cityC)
    }

    private fun setupClickListener() {
        cityListAdapter.onCityWithWeatherClickListener = {

        }
    }

    companion object {
        fun newInstance() = FavouritesCityFragment()
    }
}