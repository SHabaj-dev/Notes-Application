package com.example.notesapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val content: String,
    val imagePath: String? = null,
    val isChecklist: Boolean = false,
    val checklistItems: List<ChecklistItem> = emptyList(),
    val fontStyle: String = "normal",
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)

data class ChecklistItem(
    val id: String,
    val text: String,
    var isChecked: Boolean = false
) 