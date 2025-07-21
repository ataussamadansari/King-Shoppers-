package com.example.kingshoppers.viewModel

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.kingshoppers.model.layouts.HomeSection
import com.example.kingshoppers.model.layouts.HomeSectionWrapper
import com.example.kingshoppers.utils.dommydata.dummyJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {
    private val _sections = MutableStateFlow<List<HomeSection>>(emptyList())
    val sections: StateFlow<List<HomeSection>> = _sections

    init {
        _sections.value = parseHomeSections(dummyJson)
    }
}

fun parseHomeSections(json: String): List<HomeSection> {
    val gson = Gson()
    val type = object : TypeToken<List<HomeSectionWrapper>>() {}.type
    val wrappers: List<HomeSectionWrapper> = gson.fromJson(json, type)

    return wrappers.map {
        when (it.type) {
            "loot" -> HomeSection.LootSection(
                title = it.title,
                bgColor = safeParseColor(it.bgColor),
                gifUrl = it.gifUrl,
                items = it.items
            )
            "deal" -> HomeSection.DealSection(
                title = it.title,
                items = it.items
            )
            else -> throw IllegalArgumentException("Unknown section type: ${it.type}")
        }
    }
}

fun safeParseColor(colorString: String?): Color {
    return try {
        val finalColor = if (colorString.isNullOrBlank()) "#FFFFFF" else colorString
        Color(android.graphics.Color.parseColor(finalColor))
    } catch (e: Exception) {
        Color.White // default fallback
    }
}


