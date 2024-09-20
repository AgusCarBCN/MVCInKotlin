package model.factories

import model.foods.Food
import model.foods.Pizza

class PizzaFactory private constructor(): IFoodFactory {
    companion object
    {
        private var instance: PizzaFactory?=null

        fun getInstance(): PizzaFactory {
            if(instance ==null){
                instance = PizzaFactory()
            }
            return instance!!
        }

    }
    override fun createFood(type:String): Food = Pizza(type)
}