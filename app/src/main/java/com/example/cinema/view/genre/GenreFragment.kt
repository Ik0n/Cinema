package com.example.cinema.view.genre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cinema.R
import com.example.cinema.databinding.FilmsRecyclerBinding
import com.example.cinema.databinding.GenreRecyclerBinding
import com.example.cinema.model.Film
import com.example.cinema.model.Genre
import com.example.cinema.view.film.FilmDetailsFragment
import com.example.cinema.view.film.FilmFragmentAdapter
import com.example.cinema.view.film.FilmsFragment
import com.example.cinema.viewmodel.AppState
import com.example.cinema.viewmodel.GenreAppState
import com.example.cinema.viewmodel.GenreViewModel
import com.example.cinema.viewmodel.MainViewModel

class GenreFragment : Fragment() {

    private var _binding: GenreRecyclerBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = GenreFragment()
    }

    private lateinit var viewModel: GenreViewModel

    private val adapter = GenreFragmentAdapter(object : GenreFragmentAdapter.OnGenreClickListener{
        override fun onItemViewClick(genre: Genre) {
            val fragmentManager = activity?.supportFragmentManager

            if (fragmentManager != null) {
                val bundle = Bundle()

            }
        }

    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = GenreRecyclerBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.genreRecycler.adapter = adapter
        viewModel = ViewModelProvider(this).get(GenreViewModel::class.java)

        val observer = Observer<GenreAppState> {
            renderData(it)
        }

        viewModel.getLiveData().observe(viewLifecycleOwner, observer)
        viewModel.getGenre()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    private fun renderData(appState: GenreAppState) {
        when(appState) {
            is GenreAppState.Success -> {
                val genreData = appState.genres
                binding.genreRecyclerLoadingLayout.visibility = View.GONE
                adapter.setGenres(genreData)
            }
            is GenreAppState.Loading -> {
                binding.genreRecyclerLoadingLayout.visibility = View.VISIBLE
            }
            is GenreAppState.Error -> {
                binding.genreRecyclerLoadingLayout.visibility = View.GONE
            }
        }
    }


}