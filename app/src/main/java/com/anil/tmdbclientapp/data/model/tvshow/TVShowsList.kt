package com.anil.tmdbclientapp.data.model.tvshow


import com.anil.tmdbclientapp.data.model.tvshow.TVShow
import com.google.gson.annotations.SerializedName


data class TVShowsList(
    /*@SerializedName("page")
    val page: Int,*/
    @SerializedName("results")
    val results: List<TVShow>,
    /*@SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int*/
)