package model.factories

import model.foods.Food
import model.foods.Hamburger

class HamburgerFactory private constructor(): IFoodFactory {

    companion object
    {
        private var instance: HamburgerFactory?=null

        fun getInstance(): HamburgerFactory {
            if(instance ==null){
                instance = HamburgerFactory()
            }
            return instance!!
        }

    }

    override fun createFood(type:String): Food = Hamburger(type)
}