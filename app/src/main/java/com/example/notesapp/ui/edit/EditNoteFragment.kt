package com.example.notesapp.ui.edit

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.notesapp.R
import com.example.notesapp.data.entity.Note
import com.example.notesapp.databinding.FragmentEditNoteBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.*

@AndroidEntryPoint
class EditNoteFragment : Fragment() {
    private var _binding: FragmentEditNoteBinding? = null
    private val binding get() = _binding!!
    private val viewModel: EditNoteViewModel by viewModels()
    private val args: EditNoteFragmentArgs by navArgs()
    private var currentImageUri: Uri? = null

    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            currentImageUri = it
            binding.noteImage.apply {
                visibility = View.VISIBLE
                load(it) {
                    crossfade(true)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupBottomAppBar()
        setupImagePicker()
        setupChecklist()
        loadNote()
        observeNote()

        binding.fabSave.setOnClickListener {
            saveNote()
        }
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setupBottomAppBar() {
        binding.bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_add_image -> {
                    getContent.launch("image/*")
                    true
                }
                R.id.action_add_checklist -> {
                    toggleChecklist()
                    true
                }
                else -> false
            }
        }
    }

    private fun setupImagePicker() {
        binding.noteImage.setOnClickListener {
            getContent.launch("image/*")
        }
    }

    private fun setupChecklist() {
        binding.addChecklistItemButton.setOnClickListener {
            // Show dialog to add checklist item
        }
    }

    private fun loadNote() {
        if (args.noteId != -1L) {
            viewModel.loadNote(args.noteId)
        }
    }

    private fun observeNote() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.note.collectLatest { note ->
                note?.let {
                    binding.apply {
                        titleEditText.setText(it.title)
                        contentEditText.setText(it.content)
                        
                        if (it.imagePath != null) {
                            noteImage.visibility = View.VISIBLE
                            noteImage.load(it.imagePath) {
                                crossfade(true)
                            }
                        }

                        if (it.isChecklist) {
                            toggleChecklist()
                            // Load checklist items
                        }
                    }
                }
            }
        }
    }

    private fun toggleChecklist() {
        binding.apply {
            val isChecklist = checklistRecyclerView.visibility == View.VISIBLE
            checklistRecyclerView.visibility = if (isChecklist) View.GONE else View.VISIBLE
            addChecklistItemButton.visibility = if (isChecklist) View.GONE else View.VISIBLE
        }
    }

    private fun saveNote() {
        val title = binding.titleEditText.text.toString()
        val content = binding.contentEditText.text.toString()

        if (title.isBlank()) {
            Snackbar.make(binding.root, R.string.title_required, Snackbar.LENGTH_SHORT).show()
            return
        }

        val note = Note(
            id = args.noteId.takeIf { it != -1L } ?: 0,
            title = title,
            content = content,
            imagePath = currentImageUri?.toString(),
            isChecklist = binding.checklistRecyclerView.visibility == View.VISIBLE,
            updatedAt = Date()
        )

        viewModel.saveNote(note)
        findNavController().navigateUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 