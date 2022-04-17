package com.example.cinema.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.cinema.R
import com.example.cinema.databinding.MainFragmentBinding
import com.example.cinema.model.Film
import com.example.cinema.viewmodel.AppState
import com.example.cinema.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import java.lang.StringBuilder

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val observer = Observer<AppState> {
            renderData(it)
        }

        viewModel.getLiveData().observe(viewLifecycleOwner, observer)
        viewModel.getFilm()
    }

    private fun renderData(appState : AppState) {

        when(appState) {
            is AppState.Success -> {
                binding.loadingLayout.visibility = View.GONE
                Snackbar.make(binding.main, "Success", Snackbar.LENGTH_LONG).show()
                setData(appState.filmData)
            }
            is AppState.Loading -> {
                binding.loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                binding.loadingLayout.visibility = View.GONE

                Snackbar
                    .make(binding.main, "Error", Snackbar.LENGTH_INDEFINITE)
                    .setAction("reload") {
                        viewModel.getFilm()
                    }
                    .show()
            }
        }

    }

    private fun setData(film: Film) {
        binding.filmTitle.text = film.title
        binding.filmGenre.text = film.genre
        binding.filmYear.text = film.createdAt.toString()
        binding.filmCountry.text = film.country
        binding.filmDescription.text = film.description

        var tempString : StringBuilder = StringBuilder()
        film.actors.forEach {
            tempString.append(it.firstName)
            tempString.append(" ")
            tempString.append(it.lastName)
            tempString.append(", ")
        }

        binding.filmActors.text = tempString.toString()
    }

}