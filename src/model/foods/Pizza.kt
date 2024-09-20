package model.foods

data class Pizza(val type:String="") : Food("Pizza",8.0)
{
    override val productDescription: String
        get() = super.productDescription+" "+type

}


