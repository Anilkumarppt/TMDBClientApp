package com.anil.tmdbclientapp.presentation.artist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.anil.tmdbclientapp.data.model.aritist.Artist
import com.anil.tmdbclientapp.domain.useCases.GetArtistsListUseCase
import com.anil.tmdbclientapp.domain.useCases.UpdateArtistsListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class ArtistViewModel(
    private val getArtistsUseCaseUseCase: GetArtistsListUseCase,
    private val updateArtistsUseCaseUseCase: UpdateArtistsListUseCase
): ViewModel() {

    fun getArtists() = liveData {
        Log.i("ARTTAG","artist view model getArtists")
        val artistList = getArtistsUseCaseUseCase.execute()
        emit(artistList)
    }
    fun getPopularArtists()= flow<List<Artist>> {
        val artistList=getArtistsUseCaseUseCase.execute()
        emit(artistList!!)
    }.flowOn(Dispatchers.IO)
    fun updateArtists() = liveData {
        val artistList = updateArtistsUseCaseUseCase.execute()
        emit(artistList)
    }

}