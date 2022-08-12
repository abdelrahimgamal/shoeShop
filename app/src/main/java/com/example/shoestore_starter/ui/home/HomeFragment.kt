package com.example.shoestore_starter.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestore_starter.R
import com.example.shoestore_starter.databinding.FragmentHomeBinding
import com.example.shoestore_starter.databinding.FragmentIllustrationBinding
import com.example.shoestore_starter.databinding.ItemShoeBinding
import com.example.shoestore_starter.ui.ShoesViewModel

class HomeFragment : Fragment() {
    private lateinit var viewModel: ShoesViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        viewModel = ViewModelProvider(requireActivity())[ShoesViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.shoes.observe(viewLifecycleOwner) {
            it.forEach { shoe ->
                val itemShoeBinding: ItemShoeBinding = ItemShoeBinding.bind(
                    LayoutInflater.from(requireContext()).inflate(R.layout.item_shoe, null)
                )
                itemShoeBinding.shoe = shoe
                itemShoeBinding.executePendingBindings()
                itemShoeBinding.shoeColor.setCardBackgroundColor(Color.parseColor(viewModel.getRandomColor()))
                binding.listParent.addView(itemShoeBinding.root)
            }
        }

        binding.fab.setOnClickListener { findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAddShoeFragment()) }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLoginFragment())
        return true
    }
}