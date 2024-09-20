package model.foods

data class Sandwich(val type:String) : Food("Sandwitch",3.0)
{
    override val productDescription: String
        get() = super.productDescription+" "+type

}