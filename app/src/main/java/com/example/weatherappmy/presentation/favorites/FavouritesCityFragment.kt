package com.example.weatherappmy.presentation.favorites

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherappmy.App
import com.example.weatherappmy.R
import com.example.weatherappmy.databinding.FragmentFavouritesCityBinding
import com.example.weatherappmy.presentation.ViewModelFactory
import com.example.weatherappmy.presentation.favorites.adapter.CityListAdapter
import com.example.weatherappmy.presentation.search.SearchCityFragment
import javax.inject.Inject

class FavouritesCityFragment : Fragment() {

    private var _binding: FragmentFavouritesCityBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: FavouritesCityViewModel

    private var cityListAdapter: CityListAdapter? = null

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val component by lazy {
        (requireActivity().application as App).appComponent
    }

    companion object {
        fun newInstance() = FavouritesCityFragment()
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
        installAdapter()
        viewModel = ViewModelProvider(this, viewModelFactory)[FavouritesCityViewModel::class.java]
        install()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    private fun install() {
        observeViewModel()
        listeners()
    }

    private fun observeViewModel() {

    }

    private fun installAdapter() {
        cityListAdapter = CityListAdapter()
        binding.recyclerView.adapter = cityListAdapter
        setupSwipeListener(binding.recyclerView)
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
                val position = viewHolder.bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    cityListAdapter?.let {
                        val item = it.currentList[position]

                    }
                }
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(cityC)
    }

    private fun launchSearchCityFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main, SearchCityFragment.newInstanceAddCity())
            .addToBackStack(null)
            .commit()
    }

    private fun launchSearchCityFragmentAdd() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main, SearchCityFragment.newInstanceSearchCity())
            .addToBackStack(null)
            .commit()
    }
    private fun listeners() {
        binding.searchCardView.setOnClickListener {
            launchSearchCityFragment()
        }
        binding.extendedFloatingActionButton.setOnClickListener {
            launchSearchCityFragmentAdd()
        }
    }


}