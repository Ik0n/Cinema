package com.example.cinema.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cinema.R
import com.example.cinema.databinding.MainActivityBinding
import com.example.cinema.view.film.FilmsFragment
import com.example.cinema.view.genre.GenreFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FilmsFragment.newInstance())
                .commitNow()
        }
    }
}