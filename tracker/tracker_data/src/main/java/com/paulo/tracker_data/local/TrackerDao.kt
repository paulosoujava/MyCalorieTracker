package com.paulo.tracker_data.local

import androidx.room.*
import com.paulo.tracker_data.local.entity.TrackedFoodEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface TrackerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrackedFood(tackFoodEntity: TrackedFoodEntity)

    @Delete
    suspend fun deleteTrackedFood(trackFoodEntity: TrackedFoodEntity)

    @Query(
        """
            SELECT * 
            FROM trackedfoodentity
            WHERE dayOfMonth = :day AND month = :month AND year = :year 
            """
    )
    fun getFoodsForDAte(day: Int, month: Int, year: Int): Flow<List<TrackedFoodEntity>>
}