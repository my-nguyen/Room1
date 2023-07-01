package com.nguyen.room1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nguyen.room1.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((requireActivity().application as WordsApplication).repository)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMainBinding.bind(view)

        val adapter = WordsAdapter()
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is in the foreground.
        wordViewModel.allWords.observe(viewLifecycleOwner) { words ->
            // Update the cached copy of the words in the adapter.
            words.let { adapter.submitList(it) }
        }

        binding.fab.setOnClickListener {
            setFragmentResultListener(NewWordFragment.EXTRA_REPLY) { _, bundle ->
                val text = bundle.getString(NewWordFragment.EXTRA_WORD)
                if (text.isNullOrEmpty()) {
                    Toast.makeText(requireContext(), R.string.empty_not_saved, Toast.LENGTH_LONG)
                        .show()
                } else {
                    wordViewModel.insert(Word(text))
                }
            }
            val action = MainFragmentDirections.actionMainFragmentToNewWordFragment()
            view.findNavController().navigate(action)
        }
    }
}