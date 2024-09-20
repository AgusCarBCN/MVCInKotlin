package model

import model.foods.Food

class Order {

    private val listOFFood:ArrayList<Food> =ArrayList()
    private var price:Double=0.0
    private var id:Int=0

    val getAllFoods:ArrayList<Food>
        get() =listOFFood
    val orderId:Int
        get() =id
    val orderPrice:Double
        get() = price
init {

     counter++
     id= counter

}
    companion object{
        var counter:Int=0
    }

    fun addFoodToOrder(food: Food){
        listOFFood.add(food)
        price=updateOrderPrice()
    }


    private fun updateOrderPrice():Double{
        var newPrice=0.0
        for(food in listOFFood){
            newPrice+=food.productPrice
        }
        return newPrice
    }
}