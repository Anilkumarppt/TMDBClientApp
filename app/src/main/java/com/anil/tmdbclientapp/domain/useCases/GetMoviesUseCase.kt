package com.anil.tmdbclientapp.domain.useCases

import com.anil.tmdbclientapp.data.model.movie.Movie
import com.anil.tmdbclientapp.domain.repository.MoviesListRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val moviesListRepository: MoviesListRepository) {

    suspend fun execute():List<Movie>?=moviesListRepository.getPopularMovies()

}