package com.nguyen.room1

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.nguyen.room1.databinding.FragmentNewWordBinding

class NewWordFragment : Fragment(R.layout.fragment_new_word) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentNewWordBinding.bind(view)

        binding.buttonSave.setOnClickListener {
            val word = binding.editWord.text.toString()
            setFragmentResult(EXTRA_REPLY, bundleOf(EXTRA_WORD to word))
            findNavController().navigateUp()
        }
    }

    companion object {
        const val EXTRA_REPLY = "REPLY"
        const val EXTRA_WORD = "WORD"
    }
}