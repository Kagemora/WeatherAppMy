package com.example.weatherappmy.data.mapper

import com.example.weatherappmy.data.network.model.CurrentWeatherDto
import com.example.weatherappmy.data.network.model.CurrentWeatherIntermediateDto
import com.example.weatherappmy.data.network.model.CurrentWeatherWithForecastDto
import com.example.weatherappmy.data.network.model.DailyForecastDto
import com.example.weatherappmy.data.network.model.HoursWeatherDto
import com.example.weatherappmy.domain.entities.CurrentWeather
import com.example.weatherappmy.domain.entities.DailyWeather
import com.example.weatherappmy.domain.entities.HourlyWeather
import com.example.weatherappmy.domain.entities.Weather
import java.util.Calendar
import java.util.Date


fun CurrentWeatherIntermediateDto.toEntity(): CurrentWeather = currentWeatherDto.toEntity()

fun CurrentWeatherWithForecastDto.toEntity(): Weather = Weather(
    currentWeather = currentWeatherDto.toEntity(),
    hourlyWeather = forecast.dailyForecastDto.firstOrNull()?.hour?.map { it.toEntity() }
        ?: emptyList(),
    dailyWeather = forecast.dailyForecastDto.drop(1).map { it.toEntity() }
)

fun CurrentWeatherDto.toEntity(): CurrentWeather = CurrentWeather(
    tempC = tempC,
    time = time.toCalendar(),
    condition = condition.text,
    conditionUrl = condition.icon.correctImageUrl()
)

fun DailyForecastDto.toEntity(): DailyWeather = DailyWeather(
    time = time.toCalendar(),
    condition = day.conditionWeatherDto.text,
    conditionUrl = day.conditionWeatherDto.icon.correctImageUrl(),
    tempC = day.avgTempC
)

fun HoursWeatherDto.toEntity(): HourlyWeather = HourlyWeather(
    time = time.toCalendar(),
    condition = condition.text,
    conditionUrl = condition.icon.correctImageUrl(),
    tempC = tempC
)

fun CurrentWeatherWithForecastDto.toDailyForecastList(): List<DailyWeather> =
    forecast.dailyForecastDto.map {
        DailyWeather(
            time = it.time.toCalendar(),
            condition = it.day.conditionWeatherDto.text,
            conditionUrl = it.day.conditionWeatherDto.icon.correctImageUrl(),
            tempC = it.day.avgTempC
        )
    }

// получить почасовой прогноз для выбранного дня
fun CurrentWeatherWithForecastDto.getHourlyForecastForDay(selectedDay: Calendar): List<HourlyWeather> {
    val selectedDayEpoch = selectedDay.timeInMillis / 1000
    return forecast.dailyForecastDto
        .find { it.time.toCalendar().timeInMillis / 1000 == selectedDayEpoch }
        ?.hour
        ?.map { it.toEntity() } ?: emptyList()
}

/*это преобразование необходимо из-за того, что Calendar и Date работают с миллисекундами, а запрос
мы получаем в секундах пройденных с 1970 года 1 января Unix, соответственно умножаем на 1000
*/
fun Long.toCalendar(): Calendar = Calendar.getInstance().apply {
    time = Date(this@toCalendar * 1000)
}

/*ответ с сервера немного некорректный (маленький размер картинки и нет протокола передачи данных)
 поэтому мы делаем преобразование
*/
private fun String.correctImageUrl(): String = "https:$this".replace(
    oldValue = "64x64",
    newValue = "128x128"
)
