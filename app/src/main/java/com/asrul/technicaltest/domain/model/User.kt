package com.asrul.technicaltest.domain.model

data class User(
    val id: String,
    val currentBalance: Double,
    val name: String
)

fun generateInitialUser(): User = User(id = "ID123", currentBalance = 7000000.0, name = "M Asrul Aji Pangestu")