package com.example.kingshoppers.viewModel

import androidx.lifecycle.ViewModel
import com.example.kingshoppers.model.BrandsCategory
import com.example.kingshoppers.model.Categories
import com.example.kingshoppers.model.MasterCategory
import com.example.kingshoppers.repository.MasterCategoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MasterCategoryViewModel : ViewModel() {

    private val _masterCategories = MutableStateFlow(MasterCategoryRepository.masterCategories)
    val masterCategories: StateFlow<List<MasterCategory>> = _masterCategories

    fun getBrands(): List<BrandsCategory> {
        return _masterCategories.value.find { it.title == "Brands" }?.brandsCategory.orEmpty()
    }

    fun getCategories(): List<Categories> {
        return _masterCategories.value.find { it.title == "Categories" }?.categories.orEmpty()
    }
}
