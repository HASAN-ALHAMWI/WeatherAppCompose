package com.hasan.weatherapp.domain.repository

import com.hasan.weatherapp.domain.util.Resource
import com.hasan.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}