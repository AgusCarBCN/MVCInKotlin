package model.foods

abstract class Food (private var description: String,private var price:Double){


   open val productDescription:String
        get() =description
   open val productPrice:Double
        get() = price


}