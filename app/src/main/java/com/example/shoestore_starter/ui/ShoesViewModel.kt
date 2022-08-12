package com.example.shoestore_starter.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore_starter.R
import com.example.shoestore_starter.model.Shoe

class ShoesViewModel : ViewModel() {
    private val shoesListing = mutableListOf(
        Shoe("Nike Air Max", "40", "Nike", "Nike 1",R.drawable.nike1),
        Shoe("Nike Runner", "42", "Nike", "Nike 2",R.drawable.nike2),
        Shoe("Nike Air Max", "44", "Nike", "Nike 3",R.drawable.nike3),
        Shoe("Nike Flip flop", "43", "Nike", "Nike 4",R.drawable.nike4),
    )
    private val colors = mutableListOf(
        "#CCD7EE",
        "#EBF6FF",
        "#EFFFED",
        "#E0CFDB",
        "#FEE9FF",
        "#FFEEFE",
        "#ECEDFF",
        "#F3FDFF",
    )

    fun getRandomColor(): String {
        return colors.random()
    }


    fun addItem(shoe: Shoe) {
        shoesListing.add(shoe)
        _shoes.value = shoesListing
    }

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>> = _shoes

    init {
        _shoes.value = shoesListing
    }

}