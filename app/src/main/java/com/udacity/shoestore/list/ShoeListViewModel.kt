package com.udacity.shoestore.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()

    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        val shoes = mutableListOf<Shoe>()
        shoes.add(
            Shoe(
                name = "GEL Nimbus 24",
                size = 38.5,
                company = "ASICS",
                description = "High sole green running shoes",
                image = R.drawable.asics_1
            )
        )
        shoes.add(
            Shoe(
                name = "Air VaporMax 2021",
                size = 39.0,
                company = "Nike",
                description = "Comfy high sole shoes",
                image = R.drawable.adidas_1
            )
        )
        shoes.add(
            Shoe(
                name = "Parkour Run",
                size = 40.0,
                company = "BOSS",
                description = "Gray classic-running sneakers",
                image = R.drawable.boss_1
            )
        )
        shoes.add(
            Shoe(
                name = "B721 Embroidered",
                size = 40.5,
                company = "Fred Perry ",
                description = "Dark blue classic shoes",
                image = R.drawable.fredperry_1
            )
        )
        shoes.add(
            Shoe(
                name = "Originals NMD_V3",
                size = 41.0,
                company = "Adidas",
                description = "Large black shoes with high soles",
                image = R.drawable.nike_1
            )
        )
        shoes.add(
            Shoe(
                name = "Powercourt",
                size = 42.3,
                company = "Lacoste",
                description = "Classic finesse white shoes",
                image = R.drawable.lacoste_1
            )
        )
        shoes.add(
            Shoe(
                name = "574 Legacy",
                size = 44.0,
                company = "New Balance",
                description = "Cool red shoes",
                image = R.drawable.newbalance_1
            )
        )
        _shoeList.value = shoes
    }

    fun addShoe(shoe: Shoe) {
        Timber.i("Going to add new shoe to the list")
        _shoeList.value?.add(shoe)
    }
}
