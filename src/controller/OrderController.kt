package controller

import model.Order
import repository.FakeOrderRepository
import view.Message
import view.TypeMenu
import view.View


class OrderController private constructor() {

    private val repository: FakeOrderRepository = FakeOrderRepository()
    private val view: View = View.getInstance() // Initialize view directly

    companion object {
        private var instance: OrderController? = null

        fun getInstance(): OrderController {
            if (instance == null) {
                instance = OrderController() // Create instance with view
            }
            return instance!!
        }
    }

    fun createOrder(): Order {
        val newOrder = Order()
        repository.addOrder(newOrder)
        message(Message.CREATE)
        return newOrder
    }

    fun listAllOrders() {
        val orders = repository.getAllOrders()
        if (orders.isEmpty()) {
            println("No hay órdenes disponibles.")
        } else {
            orders.forEach { order ->
                view.showOrderSummary(order)
            }
        }
    }

    fun listOrderById(id: Int) {
        val order = repository.getOrderById(id)
        view.showOrderSummary(order)
    }

    fun removeOrderById(id: Int) {
        repository.removeOrder(id)
        message(Message.REMOVE)
    }

    fun updateView(menu: TypeMenu) {
        when (menu) {
            TypeMenu.MAIN_MENU -> view.showMainMenu()
            TypeMenu.FOOD_MENU -> view.showFoodMenu()
            TypeMenu.INGREDIENTS_MENU ->view.showIngredients()
        }
    }
    fun message(message:Message){
        when (message) {
            Message.INVALID_DATA -> view.invalidNumberOfOrder()
            Message.INVALID_OPTION -> view.invalidOptionMessage()
            Message.EXIT ->view.exitAppMessage()
            Message.REQUEST->view.requestOrderMessage()
            Message.REMOVE->view.removeOrderMessage()
            Message.CREATE->view.createOrderMessage()
        }
    }
}

