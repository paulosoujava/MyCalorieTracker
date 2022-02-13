package com.paulo.tracker_domain.usecase

import com.paulo.tracker_domain.model.TrackableFood
import com.paulo.tracker_domain.model.TrackedFood
import com.paulo.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class DeleteTrackedFood(
    private val repository: TrackerRepository
) {
     suspend operator fun invoke(trackedFood: TrackedFood){
        repository.deleteTrackedFood(trackedFood)
    }
}