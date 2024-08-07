package com.example.weatherappmy.data.mapper

import com.example.weatherappmy.data.network.model.CurrentDto
import com.example.weatherappmy.data.network.model.current.WeatherCurrentDto
import com.example.weatherappmy.data.network.model.forecast.DayDto
import com.example.weatherappmy.data.network.model.forecast.ForecastDayDto
import com.example.weatherappmy.data.network.model.forecast.HoursDto
import com.example.weatherappmy.data.network.model.forecast.WeatherForecastDto
import com.example.weatherappmy.domain.entities.DailyForecast
import com.example.weatherappmy.domain.entities.Forecast
import com.example.weatherappmy.domain.entities.HourlyForecast
import com.example.weatherappmy.domain.entities.Weather
import java.util.Calendar
import java.util.Date


fun WeatherCurrentDto.toEntity(): Weather = currentDto.toEntity()

fun WeatherForecastDto.toEntity(selectedDay: Calendar): Forecast = Forecast(
    currentWeather = currentDto.toEntity(),
    hourlyForecast = getHourlyForecastForDay(selectedDay),
    dailyForecast = forecast.forecastDayDto.drop(1).map { it.toEntity() }
)

fun CurrentDto.toEntity(): Weather = Weather(
    tempC = tempC,
    time = time.toCalendar(),
    condition = condition.text,
    conditionUrl = condition.icon.correctImageUrl()
)

fun ForecastDayDto.toEntity(): DailyForecast = DailyForecast(
    time = time.toCalendar(),
    condition = day.conditionDto.text,
    conditionUrl = day.conditionDto.icon.correctImageUrl(),
    tempC = day.avgTempC
)

fun HoursDto.toEntity(): HourlyForecast = HourlyForecast(
    time = time.toCalendar(),
    condition = condition.text,
    conditionUrl = condition.icon.correctImageUrl(),
    tempC = tempC
)

// получить почасовой прогноз для выбранного дня
private fun WeatherForecastDto.getHourlyForecastForDay(selectedDay: Calendar): List<HourlyForecast> {
    val selectedDayEpoch = selectedDay.timeInMillis / 1000
    return forecast.forecastDayDto
        .find { it.time.toCalendar().timeInMillis / 1000 == selectedDayEpoch }
        ?.hour
        ?.map { it.toEntity() } ?: emptyList()
}

/*это преобразование необходимо из-за того, что Calendar и Date работают с миллисекундами, а запрос
мы получаем в секундах пройденных с 1970 года 1 января Unix, соответственно умножаем на 1000
*/
private fun Long.toCalendar(): Calendar = Calendar.getInstance().apply {
    time = Date(this@toCalendar * 1000)
}

/*ответ с сервера немного некорректный (маленький размер картинки и нет протокола передачи данных)
 поэтому мы делаем преобразование
*/
private fun String.correctImageUrl(): String = "https:$this".replace(
    oldValue = "64x64",
    newValue = "128x128"
)