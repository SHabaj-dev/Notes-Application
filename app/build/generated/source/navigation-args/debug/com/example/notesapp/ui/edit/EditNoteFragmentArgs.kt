package com.example.notesapp.ui.edit

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Long
import kotlin.jvm.JvmStatic

public data class EditNoteFragmentArgs(
  public val noteId: Long = -1L,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putLong("noteId", this.noteId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("noteId", this.noteId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): EditNoteFragmentArgs {
      bundle.setClassLoader(EditNoteFragmentArgs::class.java.classLoader)
      val __noteId : Long
      if (bundle.containsKey("noteId")) {
        __noteId = bundle.getLong("noteId")
      } else {
        __noteId = -1L
      }
      return EditNoteFragmentArgs(__noteId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): EditNoteFragmentArgs {
      val __noteId : Long?
      if (savedStateHandle.contains("noteId")) {
        __noteId = savedStateHandle["noteId"]
        if (__noteId == null) {
          throw IllegalArgumentException("Argument \"noteId\" of type long does not support null values")
        }
      } else {
        __noteId = -1L
      }
      return EditNoteFragmentArgs(__noteId)
    }
  }
}
