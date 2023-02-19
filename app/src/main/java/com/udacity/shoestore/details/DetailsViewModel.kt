package com.udacity.shoestore.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe
import timber.log.Timber
import java.util.*

class DetailsViewModel : ViewModel() {

    val name = MutableLiveData<String>()
    val size = MutableLiveData<String>()
    val company = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val image = MutableLiveData<Int>()

    fun createShoe(): Shoe {
        Timber.i("New shoe going to be created using DetailsViewModel")
        return Shoe(
            name = name.value.toString(),
            size = size.value?.toDouble() ?: generateRandomDouble(),
            company = company.value.toString(),
            description = description.value.toString(),
            image = image.value ?: R.drawable.placeholder
        )
    }

    fun validParameters(): Boolean {
        Timber.i("Name is empty: ${name.value.isNullOrEmpty()}")
        Timber.i("Company is empty: ${company.value.isNullOrEmpty()}")
        Timber.i("Description is empty: ${description.value.isNullOrEmpty()}")
        Timber.i("Size is empty: ${size.value.isNullOrEmpty()}")

        return !name.value.isNullOrEmpty() &&
                !company.value.isNullOrEmpty() &&
                !description.value.isNullOrEmpty() &&
                !size.value.isNullOrEmpty()
    }

    fun generateRandomDouble(): Double {
        return Random().nextDouble()
    }
}