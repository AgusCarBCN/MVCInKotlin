package model.factories

import model.foods.Food

interface IFoodFactory {
    fun createFood(type:String): Food
}