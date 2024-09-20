package model.factories

import model.foods.FoodType


class FoodFactory private constructor() {

    companion object{

    fun createFactory(type: FoodType): IFoodFactory {
        val factory=when (type) {
            FoodType.PIZZA -> PizzaFactory.getInstance()
            FoodType.HAMBURGER -> HamburgerFactory.getInstance()
            FoodType.SANDWICH -> SandwitchFactory.getInstance()
        }
        return factory
    }
  }
}