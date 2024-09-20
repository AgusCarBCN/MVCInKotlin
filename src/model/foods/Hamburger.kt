package model.foods

data class Hamburger(val type: String="") : Food("Hamburgesa",6.0)
{
    override val productDescription: String
        get() = super.productDescription+" "+type

}
