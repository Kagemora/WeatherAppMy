package com.example.weatherappmy.data.repository


import com.example.weatherappmy.data.mapper.toEntities
import com.example.weatherappmy.data.network.WeatherApi
import com.example.weatherappmy.domain.entities.City
import com.example.weatherappmy.domain.repository.SearchRepository
import com.example.weatherappmy.domain.util.NetworkError
import com.example.weatherappmy.domain.util.Resource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : SearchRepository {

    override suspend fun search(query: String): Resource<List<City>> {
        return handleNetworkErrors {
            api.loadSearchCity(query).toEntities()
        }
    }

    private suspend fun <T> handleNetworkErrors(action: suspend () -> T): Resource<T> {
        return try {
            Resource.Success(action())
        } catch (e: IOException) {
            Resource.Error(NetworkError.NoInternet)
        } catch (e: HttpException) {
            Resource.Error(NetworkError.ServerError)
        } catch (e: Exception) {
            Resource.Error(NetworkError.UnknownError(e.message))
        }
    }
}