package view

import model.Order
import model.foods.Food

class View private constructor(){

    companion object
    {
        private var instance: View?=null

        fun getInstance(): View {
            if(instance ==null){
                instance = View()
            }
            return instance!!
        }
    }

    fun showMainMenu()
    {
        println("Menú de Pedidos:")
        println("1. Crear nuevo pedido.")
        println("2. Mostrar un pedido.")
        println("3. Mostrar todos los pedidos.")
        println("4. Borrar un pedido.")
        println("5. Salir")

    }

    private fun showListOfFood(listOfFood:MutableList<Food>) {
        for(element in listOfFood){
            println(String.format("%-30s %10.2f", element.productDescription, element.productPrice))
        }
    }

    fun showFoodMenu(){
        println("Tipos de comida:")
        println("1. Pizza.")
        println("2. Hamburguesa.")
        println("3. Sandwitch.")
        println("4. Finalizar pedido.")
    }
    fun showIngredients(){
        println("Ingredientes:")
        println("1. Salsa.")
        println("2. Queso.")
        println("3. Nada.")
    }

    fun showOrderSummary(order: Order) {
        println("--------------------------------------------------------")
        showListOfFood(order.getAllFoods)
        println("--------------------------------------------------------")
        println(String.format("Número de pedido: %-6s Total:%10.2f", order.orderId, order.orderPrice))
        println("--------------------------------------------------------")
    }

    fun requestOrderMessage(){
        println("Introducir un numero de pedido a mostrar: ")
    }
    fun removeOrderMessage(){
        println("Has borrado un pedido")
    }
    fun createOrderMessage(){
        println("Has creado un pedido")
    }

    fun invalidOptionMessage(){
        println("Opción no válida. Intenta de nuevo.")
    }
    fun invalidNumberOfOrder()
    {
        println("Numero de pedido no encontrado.")
    }
    fun exitAppMessage(){
        println("Saliendo del programa...")
    }

}