package com.example.constructorapp

data class CheckBoxParameters(
    val title: String,
    var isChecked: Boolean = false,
    var onCheckedChanged: (Boolean) -> Unit
)