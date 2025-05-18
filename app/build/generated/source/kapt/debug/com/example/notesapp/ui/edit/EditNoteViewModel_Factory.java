package com.example.notesapp.ui.edit;

import com.example.notesapp.repository.NoteRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class EditNoteViewModel_Factory implements Factory<EditNoteViewModel> {
  private final Provider<NoteRepository> repositoryProvider;

  public EditNoteViewModel_Factory(Provider<NoteRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public EditNoteViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static EditNoteViewModel_Factory create(Provider<NoteRepository> repositoryProvider) {
    return new EditNoteViewModel_Factory(repositoryProvider);
  }

  public static EditNoteViewModel newInstance(NoteRepository repository) {
    return new EditNoteViewModel(repository);
  }
}
