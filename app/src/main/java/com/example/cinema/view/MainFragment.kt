package com.example.cinema.view

import android.graphics.drawable.Drawable
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
import com.squareup.picasso.Picasso
import java.lang.StringBuilder
import java.text.SimpleDateFormat

class MainFragment : Fragment() {
/*
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

        binding.filmTitleAlternative.text = String.format(
            getString(R.string.alternative_title),
            film.titleAlternative,
            film.createdAt.toString()
        )

        Picasso.get().load(film.avatar).into(binding.filmAvatar)

        var tempString = StringBuilder()
        film.genre.forEach {
            tempString.append(it)
            tempString.append(", ")
        }
        binding.filmGenre.text = tempString
        tempString = StringBuilder()

        binding.filmDuration.text = film.duration.toString()
        binding.filmBudget.text = binding.filmBudget.text.toString() + " " + film.budget.toString()
        binding.filmRevenue.text = binding.filmRevenue.text.toString() + " " + film.revenue.toString()
        binding.filmRealeseDate.text =
            binding.filmRealeseDate.text.toString() +
                    SimpleDateFormat("dd.MM.yy").format(film.releaseDate)
        binding.filmCountry.text = film.country
        film.actors.forEach {
            tempString.append(it.firstName)
            tempString.append(" ")
            tempString.append(it.lastName)
            tempString.append("\n")
        }
        binding.filmActors.text = tempString
        binding.filmDescription.text = film.description
    }
*/
}