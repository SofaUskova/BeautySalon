package com.example.beautysalon

import android.graphics.drawable.Drawable

fun createListMaster(listDrawables: List<Drawable>): List<Master> {
    val list: MutableList<Master> = mutableListOf()
    list.add(
        createListMasterOne(listDrawables[0])[0]
    )
    list.add(
        createListMasterTwo(listDrawables[1])[0]
    )
    return list
}

fun createListMasterOne(listDrawables: Drawable): List<Master> {
    val list: MutableList<Master> = mutableListOf()
    list.add(
        Master(
            "Мастер Мастер Мастерович",
            listOf(
                "Маникюр",
                "Маникюр + гель-лак",
                "Наращивание",
                "Коррекция",
                "Наращивание ресниц (классика)",
                "Наращивание ресниц (3D)"
            ),
            listOf("Маникюр", "Маникюр + гель-лак", "Наращивание"),
            listOf("8:00", "10:00", "12:00", "14:00", "16:00", "18:00"),
            mapOf("21.04" to "10:00"),
            listDrawables
        )
    )
    return list
}

fun createListMasterTwo(listDrawables: Drawable): List<Master> {
    val list: MutableList<Master> = mutableListOf()
    list.add(
        Master(
            "Второймастер Мастер Мастерович",
            listOf(
                "RF-лифтинг",
                "Кавитация",
                "Липолиз",
                "Вакуум",
                "Медовый массаж",
                "Карбоновый пилинг"
            ),
            listOf("RF-лифтинг", "Кавитация", "Липолиз",),
            listOf("7:00", "9:00", "11:00", "13:00", "15:00", "17:00"),
            mapOf("21.04" to "9:00"),
            listDrawables
        )
    )
    return list
}