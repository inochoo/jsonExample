package com.sibaamap.jsonexample.Model

data class Users(
    val users: ArrayList<UserModelClass>
)

class UserModelClass(
    val id: Int,
    val name: String,
    val email: String,
    val gender: String,
    val weight: Double,
    val height: Int,
    val phone: Phone
)
data class Phone(
    val mobile: String,
    val office: String
)