package com.example.littlelemon

import androidx.annotation.DrawableRes

object DishRepository {
    val dishes = listOf(
        Dish(
            1,
            "Greek Salad",
            "$12.99",
            "The famous greek salad of crispy lettuce, peppers, olives and our Chicago...",
            R.drawable.greeksalad
        ),
        Dish(
            2,
            "Bruschetta",
            "$5.99",
            "Our Bruschetta is made from grilled bread that has been smeared with garlic...",
            R.drawable.bruschetta
        ),
        Dish(
            3,
            "Lemon Dessert",
            "$9.99",
            "This comes straight from grandma recipe book, every last ingredient has...",
            R.drawable.lemondessert
        ),
        Dish(
            4,
            "Greek Salad",
            "$12.99",
            "The famous greek salad of crispy lettuce, peppers, olives and our Chicago...",
            R.drawable.greeksalad
        ),
        Dish(
            5,
            "Bruschetta",
            "$5.99",
            "Our Brushetta is made from grilled bread that has been smeared with garlic...",
            R.drawable.bruschetta
        ),
        Dish(
            6,
            "Lemon Dessert",
            "$9.99",
            "This comes straight from grandma recipe book, every last ingredient has...",
            R.drawable.lemondessert
        ),
        Dish(7,
            "Greek Salad",
            "$12.99",
            "The famous greek salad of crispy lettuce, peppers, olives and our Chicago...",
            R.drawable.greeksalad
        ),
        Dish(
            8,
            "Bruschetta",
            "$5.99",
            "Our Brushetta is made from grilled bread that has been smeared with garlic...",
            R.drawable.bruschetta
        ),
        Dish(9,
            "Lemon Dessert",
            "$9.99",
            "This comes straight from grandma recipe book, every last ingredient has...",
            R.drawable.lemondessert
        )
    )
    fun getDish(id: Int) = dishes.firstOrNull { it.id == id }
}


data class Dish(
    val id: Int,
    val name: String,
    val price: String,
    val description: String,
    @DrawableRes val imageResource: Int
)