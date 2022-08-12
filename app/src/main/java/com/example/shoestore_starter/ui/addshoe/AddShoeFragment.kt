package com.example.shoestore_starter.ui.addshoe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestore_starter.R
import com.example.shoestore_starter.databinding.FragmentAddShoeBinding
import com.example.shoestore_starter.databinding.FragmentIllustrationBinding
import com.example.shoestore_starter.model.Shoe
import com.example.shoestore_starter.ui.ShoesViewModel

class AddShoeFragment : Fragment() {
    private var _binding: FragmentAddShoeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ShoesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add_shoe, container, false
        )
        binding.shoe = Shoe("", "", "", "", R.drawable.nike5)

        viewModel = ViewModelProvider(requireActivity())[ShoesViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.discardButton.setOnClickListener {
            Toast.makeText(requireContext(), "Shoe Discarded", Toast.LENGTH_SHORT).show()
            findNavController().navigateUp()
        }
        binding.saveButton.setOnClickListener {
            Toast.makeText(requireContext(), "Shoe Added", Toast.LENGTH_SHORT).show()
            viewModel.addItem(binding.shoe!!)
            findNavController().navigateUp()
        }
    }
}