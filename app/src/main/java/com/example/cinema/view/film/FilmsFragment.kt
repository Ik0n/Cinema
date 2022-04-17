package com.example.cinema.view.film

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cinema.R
import com.example.cinema.databinding.FilmsRecyclerBinding
import com.example.cinema.model.Film
import com.example.cinema.viewmodel.AppState
import com.example.cinema.viewmodel.MainViewModel

class FilmsFragment : Fragment() {

    private var _binding: FilmsRecyclerBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = FilmsFragment()
    }

    private lateinit var viewModel: MainViewModel


    private val adapter = FilmFragmentAdapter(object : FilmFragmentAdapter.OnItemViewClickListener {
        override fun onItemViewClick(film: Film) {
            val fragmentManager = activity?.supportFragmentManager

            if (fragmentManager != null) {
                val bundle = Bundle()
                bundle.putParcelable(FilmDetailsFragment.BUNDLE_EXTRA, film)
                fragmentManager.beginTransaction()
                    .replace(R.id.container, FilmDetailsFragment.newInstance(bundle))
                    .addToBackStack("")
                    .commitAllowingStateLoss()
            }
        }

    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FilmsRecyclerBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.filmsRecycler.adapter = adapter
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val observer = Observer<AppState> {
            renderData(it)
        }

        viewModel.getLiveData().observe(viewLifecycleOwner, observer)
        viewModel.getFilm()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    private fun renderData(appState: AppState) {
        when(appState) {
            is AppState.Success -> {
                val filmsData = appState.filmData
                binding.filmsRecyclerLoadingLayout.visibility = View.GONE
                adapter.setFilms(filmsData)
            }
            is AppState.Loading -> {
                binding.filmsRecyclerLoadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                binding.filmsRecyclerLoadingLayout.visibility = View.GONE
            }
        }
    }

}