package com.example.notesapp.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.notesapp.databinding.FragmentSettingsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SettingsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupThemeSwitch()
        setupFontStyleGroup()
    }

    private fun setupThemeSwitch() {
        binding.darkModeSwitch.apply {
            isChecked = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES
            setOnCheckedChangeListener { _, isChecked ->
                viewModel.setDarkMode(isChecked)
            }
        }
    }

    private fun setupFontStyleGroup() {
        binding.fontStyleGroup.setOnCheckedChangeListener { _, checkedId ->
            val fontStyle = when (checkedId) {
                binding.fontNormal.id -> "normal"
                binding.fontSerif.id -> "serif"
                binding.fontMonospace.id -> "monospace"
                else -> "normal"
            }
            viewModel.setFontStyle(fontStyle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 