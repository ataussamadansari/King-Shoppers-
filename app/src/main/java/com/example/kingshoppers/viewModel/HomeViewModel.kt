package com.example.kingshoppers.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import com.example.kingshoppers.model.MasterCategory
import com.example.kingshoppers.utils.dommydata.getDummyCategories


class HomeViewModel : ViewModel() {

    private val _categories = mutableStateOf<List<MasterCategory>>(emptyList())
    val categories: State<List<MasterCategory>> = _categories

    init {
        loadLocalCategories()
    }

    private fun loadLocalCategories() {
        _categories.value = getDummyCategories()
    }
}
