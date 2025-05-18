package com.example.notesapp.util

import androidx.room.TypeConverter
import com.example.notesapp.data.entity.ChecklistItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Date

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromChecklistItems(items: List<ChecklistItem>): String {
        return gson.toJson(items)
    }

    @TypeConverter
    fun toChecklistItems(itemsString: String): List<ChecklistItem> {
        val listType = object : TypeToken<List<ChecklistItem>>() {}.type
        return gson.fromJson(itemsString, listType) ?: emptyList()
    }
} 