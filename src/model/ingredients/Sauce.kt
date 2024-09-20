package model.ingredients

import model.foods.Food

data class Sauce(val wrapped: Food) : Ingredients(wrapped, "con salsa", 1.5)


