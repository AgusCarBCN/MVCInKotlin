// repository/FakeOrderRepository.kt
package repository

import model.Order
import model.OrderingSystem

class FakeOrderRepository : OrderRepository {
    private val orderingSystem = OrderingSystem.getInstance()  // Sistema que maneja las órdenes

    override fun getAllOrders():MutableList<Order> = orderingSystem.getAllOfOrders()

    override fun getOrderById(id: Int): Order = orderingSystem.getOrderById(id)

    override fun addOrder(order: Order) {
        orderingSystem.addOrder(order)
    }
    override fun removeOrder(id: Int) {
        orderingSystem.removeOrderById(id)
    }

}

