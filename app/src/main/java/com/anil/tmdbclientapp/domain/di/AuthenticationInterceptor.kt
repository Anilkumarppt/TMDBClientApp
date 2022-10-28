package com.anil.tmdbclientapp.domain.di

import com.anil.tmdbclientapp.utils.APIConstants

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class AuthenticationInterceptor @Inject constructor():Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original:Request=chain.request()
        val originalHTTPUrl:HttpUrl=original.url

        val url=originalHTTPUrl.newBuilder().
                addQueryParameter(APIConstants.API_PARAM, APIConstants.API_KEY)
            .build()
        val requestBuilder:Request.Builder=original.newBuilder().url(url)
        val request:Request=requestBuilder.build()
        return chain.proceed(request)

    }
}