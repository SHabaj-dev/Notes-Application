package com.example.notesapp.ui.home

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.notesapp.R
import kotlin.Int
import kotlin.Long

public class HomeFragmentDirections private constructor() {
  private data class ActionHomeToEdit(
    public val noteId: Long = -1L,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_home_to_edit

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putLong("noteId", this.noteId)
        return result
      }
  }

  public companion object {
    public fun actionHomeToEdit(noteId: Long = -1L): NavDirections = ActionHomeToEdit(noteId)
  }
}
