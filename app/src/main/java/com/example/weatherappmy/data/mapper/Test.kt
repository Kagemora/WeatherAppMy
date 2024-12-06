package com.example.weatherappmy.data.mapper

import com.example.weatherappmy.data.network.model.CurrentWeatherDto
import com.example.weatherappmy.data.network.model.CurrentWeatherWithForecastDto
import com.example.weatherappmy.data.network.model.DailyForecastDto
import com.example.weatherappmy.data.network.model.HoursWeatherDto
import com.example.weatherappmy.domain.entities.CurrentWeather
import com.example.weatherappmy.domain.entities.DailyWeather
import com.example.weatherappmy.domain.entities.HourlyWeather
import com.example.weatherappmy.domain.entities.Weather
import java.util.Calendar
import java.util.Date

class Test {

    fun mapToWeather(currentWeatherWithForecastDto: CurrentWeatherWithForecastDto): Weather =
        Weather(
            currentWeather = mapToCurrentWeather(currentWeatherWithForecastDto.currentWeatherDto),
            hourlyWeather = currentWeatherWithForecastDto.forecast.dailyForecastDto.flatMap {
                it.hour.map(::mapToHourlyWeather)
            },
            dailyWeather = currentWeatherWithForecastDto.forecast.dailyForecastDto.drop(1)
                .map(::mapToDailyWeather)
        )


    private fun mapToCurrentWeather(currentWeatherDto: CurrentWeatherDto): CurrentWeather =
        CurrentWeather(
            condition = currentWeatherDto.condition.text,
            time = currentWeatherDto.time.toCalendar(),
            conditionUrl = currentWeatherDto.condition.icon.correctImageUrl(),
            tempC = currentWeatherDto.tempC
        )

    private fun mapToDailyWeather(dailyForecastDto: DailyForecastDto): DailyWeather = DailyWeather(
        time = dailyForecastDto.time.toCalendar(),
        condition = dailyForecastDto.day.conditionWeatherDto.text,
        conditionUrl = dailyForecastDto.day.conditionWeatherDto.icon.correctImageUrl(),
        tempC = dailyForecastDto.day.avgTempC
    )

    private fun mapToHourlyWeather(dto: HoursWeatherDto): HourlyWeather = HourlyWeather(
        time = dto.time.toCalendar(),
        condition = dto.condition.text,
        conditionUrl = dto.condition.icon.correctImageUrl(),
        tempC = dto.tempC
    )


    private fun Long.toCalendar(): Calendar = Calendar.getInstance().apply {
        time = Date(this@toCalendar * 1000)
    }

    private fun String.correctImageUrl(): String = "https:$this".replace(
        oldValue = "64x64",
        newValue = "128x128"
    )

}