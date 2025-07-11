package com.example.kingshoppers.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.kingshoppers.model.Category
import com.example.kingshoppers.utils.dommydata.getDummyCategories
import androidx.compose.runtime.State


class HomeViewModel : ViewModel() {

    private val _categories = mutableStateOf<List<Category>>(emptyList())
    val categories: State<List<Category>> = _categories

    init {
        loadLocalCategories()
    }

    private fun loadLocalCategories() {
        _categories.value = getDummyCategories()
    }
}
