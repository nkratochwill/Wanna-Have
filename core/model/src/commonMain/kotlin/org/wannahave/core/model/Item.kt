package org.wannahave.core.model

import kotlin.random.Random
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

data class Item(
    // Core Identity
    val id: String,

    // Basic Item Information
    val title: String, val description: String, val category: String,

    // Visuals
    val imageUrl: String,

    // Timestamps
    val createdAt: Long,

    // Progress Tracking
    val currentProgress: Float = 0f, // Progress as a fraction (0.0 to 1.0)
    val duration: Long = 0L //Total duration of the movie or tv show in milliseconds

) {
    init {
        require(id.isNotBlank()) { "Item ID cannot be blank" }
        require(title.isNotBlank()) { "Title cannot be blank" }
        require(description.isNotBlank()) { "Description cannot be blank" }
        require(category.isNotBlank()) { "Category cannot be blank" }
        require(imageUrl.isNotBlank()) { "Image URL is required" }
        require(createdAt > 0) { "Creation date must be valid" }
        require(currentProgress in 0.0f..1.0f) { "current progress must be between 0.0 and 1.0" }
        require(duration >= 0) { "duration must be at least 0" }
    }
    companion object {
        @OptIn(ExperimentalUuidApi::class, ExperimentalTime::class)
        fun generateSampleItem(id: String = Uuid.random().toString()): Item {
            val random = Random.Default
            val now = kotlin.time.Clock.System.now()
            val createdAt = now.minus(kotlin.time.Duration.parse("${random.nextLong(0, 1)}ms"))
                .toEpochMilliseconds()
            val duration = random.nextLong(3600000, 10800000)//from 1 hour to 3
            return Item(
                id = id,
                title = "Sample Item ${random.nextInt(1000)}",
                description = "This is a sample item description.",
                category = listOf("Action", "Comedy", "Drama", "Sci-Fi", "Thriller").random(),
                imageUrl = "https://picsum.photos/512/256.jpg", // You can add more dummy URLs here
                createdAt = createdAt,
                currentProgress = random.nextFloat(),
                duration = duration
            )
        }

        fun generateSampleItems(count: Int): List<Item> {
            return List(count) { generateSampleItem() }
        }
    }
}