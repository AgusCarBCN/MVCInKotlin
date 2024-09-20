package model.factories

import model.foods.Food
import model.foods.Sandwich

class SandwitchFactory private constructor(): IFoodFactory {

    companion object
    {
        private var instance: SandwitchFactory?=null

        fun getInstance(): SandwitchFactory {
            if(instance ==null){
                instance = SandwitchFactory()
            }
            return instance!!
        }

    }

    override fun createFood(type:String): Food = Sandwich(type)
}