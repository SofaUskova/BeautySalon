package com.example.beautysalon

import android.graphics.drawable.Drawable

data class Master(
    val name: String,
    val skills: List<String>,
    val shortSkills: List<String>,
    val recordsTime: List<String>,
    val records: Map<String, String>,
    val image: Drawable
)
