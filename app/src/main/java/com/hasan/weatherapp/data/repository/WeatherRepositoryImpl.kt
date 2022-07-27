package com.hasan.weatherapp.data.repository

import com.hasan.weatherapp.data.mapper.toWeatherInfo
import com.hasan.weatherapp.data.remote.WeatherApi
import com.hasan.weatherapp.domain.repository.WeatherRepository
import com.hasan.weatherapp.domain.util.Resource
import com.hasan.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try{
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception){
            e.printStackTrace()
            Resource.Error(e.message?: "An unknown error occurred")
        }
    }
}