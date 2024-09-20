
    // repository/OrderRepository.kt
    package repository

    import model.Order

    interface OrderRepository {
        fun getAllOrders():MutableList<Order>
        fun getOrderById(id: Int): Order?
        fun addOrder(order: Order)
        fun removeOrder(id: Int)
    }

