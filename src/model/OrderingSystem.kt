package model

import java.util.*
import kotlin.collections.ArrayList

class OrderingSystem private constructor() {

    private var listOfOrders:MutableList<Order> =ArrayList()

    companion object
    {
        private var instance: OrderingSystem?=null

        fun getInstance(): OrderingSystem {
            if(instance ==null){
                instance = OrderingSystem()
            }
            return instance!!
        }

    }
    fun addOrder(order: Order)=listOfOrders.add(order)


    fun getOrderById(idOrder: Int): Order {
        val iterator = listOfOrders.iterator()  // Crear el iterator para el ArrayList

        while (iterator.hasNext()) {
            val order = iterator.next()    // Obtener el siguiente elemento
            if (order.orderId == idOrder) {
                return order  // Retornar la orden encontrada
            }
        }
        // Si no se encontró la orden, lanzar excepción o mostrar mensaje
        throw NoSuchElementException("No se encontró ninguna orden con el ID $idOrder")
    }
    fun removeOrderById(idOrder: Int) {
        val iterator = listOfOrders.iterator()  // Crear el iterator para el ArrayList
        var orderFound = false

        while (iterator.hasNext()) {
            val order = iterator.next()    // Obtener el siguiente elemento
            if (order.orderId == idOrder) {
                iterator.remove()  // Usar el método remove() del iterator
                orderFound = true
                break  // Salir del bucle después de eliminar la orden
            }
        }

        if (!orderFound) {
            // Si no se encontró la orden, lanzar excepción
            throw NoSuchElementException("No se encontró ninguna orden con el ID $idOrder")
        }
    }


    fun getAllOfOrders():MutableList<Order>{
        return listOfOrders
    }


}