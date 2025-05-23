// Generated by view binder compiler. Do not edit!
package com.example.notesapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.notesapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final RecyclerView notesRecyclerView;

  @NonNull
  public final TextInputEditText searchEditText;

  @NonNull
  public final TextInputLayout searchLayout;

  private FragmentHomeBinding(@NonNull CoordinatorLayout rootView,
      @NonNull RecyclerView notesRecyclerView, @NonNull TextInputEditText searchEditText,
      @NonNull TextInputLayout searchLayout) {
    this.rootView = rootView;
    this.notesRecyclerView = notesRecyclerView;
    this.searchEditText = searchEditText;
    this.searchLayout = searchLayout;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.notes_recycler_view;
      RecyclerView notesRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (notesRecyclerView == null) {
        break missingId;
      }

      id = R.id.search_edit_text;
      TextInputEditText searchEditText = ViewBindings.findChildViewById(rootView, id);
      if (searchEditText == null) {
        break missingId;
      }

      id = R.id.search_layout;
      TextInputLayout searchLayout = ViewBindings.findChildViewById(rootView, id);
      if (searchLayout == null) {
        break missingId;
      }

      return new FragmentHomeBinding((CoordinatorLayout) rootView, notesRecyclerView,
          searchEditText, searchLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
