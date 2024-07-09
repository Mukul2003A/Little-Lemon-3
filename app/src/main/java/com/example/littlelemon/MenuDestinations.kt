package com.example.littlelemon

interface MenuDestinations {
    val route: String
}

object MenuHome : MenuDestinations {
    override val route = "MenuHome"
}

object DishDetails : MenuDestinations {
    override val route = "Menu"
    const val argDishId = "dishId"
}
