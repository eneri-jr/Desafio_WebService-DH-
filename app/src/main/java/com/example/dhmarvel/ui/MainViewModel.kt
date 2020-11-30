package com.example.dhmarvel.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dhmarvel.entities.Hq
import com.example.dhmarvel.service.Repository
import kotlinx.coroutines.launch


class MainViewModel(val repository: Repository): ViewModel(){

    var listHqs = MutableLiveData<ArrayList<Hq>>()

    fun popListHqs() {
        viewModelScope.launch {
            val jsonApiMarvel = repository.getHqs(
                "issueNumber",
                0,
                20,
                1,
                    "6eb7e8896ec5850c52515a8a23ee97f0",
                    "40a3aa568bb269dfad85ae0c4a297181"
            )

            listHqs.value = jsonApiMarvel.data.results
        }
    }
}