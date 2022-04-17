package com.example.cinema.view.film

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cinema.R
import com.example.cinema.databinding.FilmDetailsBinding
import com.example.cinema.model.Film
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat

class FilmDetailsFragment : Fragment() {

    private var _binding : FilmDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FilmDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val film = arguments?.getParcelable<Film>(BUNDLE_EXTRA)

        if (film != null) {
            binding.filmTitle.text = film.title

            binding.filmTitleAlternative.text = String.format(
                getString(R.string.alternative_title),
                film.titleAlternative,
                film.createdAt.toString()
            )

            Picasso.get().load(film.avatar).into(binding.filmAvatar)

            var tempString = StringBuilder()
            film.genre.forEach {
                tempString.append(it.title)
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val BUNDLE_EXTRA = "film"

        fun newInstance(bundle: Bundle): FilmDetailsFragment {
            val fragment = FilmDetailsFragment ()
            fragment.arguments = bundle

            return fragment
        }
    }

}