package com.example.notesapp.ui.edit;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/notesapp/ui/edit/EditNoteViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/notesapp/repository/NoteRepository;", "(Lcom/example/notesapp/repository/NoteRepository;)V", "_note", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/notesapp/data/entity/Note;", "note", "Lkotlinx/coroutines/flow/StateFlow;", "getNote", "()Lkotlinx/coroutines/flow/StateFlow;", "loadNote", "", "id", "", "saveNote", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class EditNoteViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.notesapp.repository.NoteRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.notesapp.data.entity.Note> _note = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.notesapp.data.entity.Note> note = null;
    
    @javax.inject.Inject()
    public EditNoteViewModel(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.repository.NoteRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.notesapp.data.entity.Note> getNote() {
        return null;
    }
    
    public final void loadNote(long id) {
    }
    
    public final void saveNote(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.data.entity.Note note) {
    }
}