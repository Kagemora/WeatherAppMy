package com.example.weatherappmy.data.cache

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherappmy.data.cache.model.CityDbModel

@Dao
interface FavouriteCityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCity(cityDbModel: CityDbModel)

    @Query("DELETE FROM favourite_city WHERE id=:cityId")
    suspend fun deleteCity(cityId: Int)

    @Query("SELECT * FROM favourite_city")
    fun getFavouriteCity(): LiveData<List<CityDbModel>>

    @Query("SELECT EXISTS(SELECT *FROM favourite_city WHERE id=:cityId LIMIT 1)")
    fun getObserveIsCity(cityId: Int): LiveData<Boolean>
}