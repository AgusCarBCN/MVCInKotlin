package model.ingredients

import model.foods.Food

//Clase abstracta de patron Decorator

abstract class Ingredients(private val wrapped: Food, description: String, price: Double) : Food(description, price) {


    override val productDescription: String
        get() = wrapped.productDescription+super.productDescription
    override val productPrice: Double
        get() = wrapped.productPrice+super.productPrice
}
