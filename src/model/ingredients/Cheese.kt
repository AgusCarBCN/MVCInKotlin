package model.ingredients

import model.foods.Food

data class Cheese(val wrapped: Food) : Ingredients(wrapped, "con queso", 3.0)


