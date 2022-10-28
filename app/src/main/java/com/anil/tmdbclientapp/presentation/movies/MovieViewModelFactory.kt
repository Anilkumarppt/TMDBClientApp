package com.anil.tmdbclientapp.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anil.tmdbclientapp.domain.useCases.GetMoviesUseCase
import com.anil.tmdbclientapp.domain.useCases.UpdateMovieUseCase

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MoviesViewModel(getMoviesUseCase,updateMovieUseCase) as T
    }
}