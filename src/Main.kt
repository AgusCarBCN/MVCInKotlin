import controller.OrderController
import model.Order
import model.factories.FoodFactory
import model.foods.FoodType
import model.ingredients.Cheese
import model.ingredients.Sauce
import view.Message
import view.TypeMenu
import java.util.*

private lateinit var controller:OrderController
private lateinit var  scanner:Scanner


fun main() {
    scanner = Scanner(System.`in`)
    controller = OrderController.getInstance()
    var exit = false
    do {
        // Mostrar el menú principal y capturar la opción seleccionada
        controller.updateView(TypeMenu.MAIN_MENU)
        val optionMainMenu = scanner.nextLine().toIntOrNull()

        when (optionMainMenu) {
            1 -> {
                // Crear un nuevo pedido
                val newOrder = controller.createOrder()
                var exitFoodMenu = false

                // Mostrar el menú de comida y capturar la opción seleccionada
                while (!exitFoodMenu) {
                    controller.updateView(TypeMenu.FOOD_MENU)
                    val optionFood = scanner.nextLine().toIntOrNull()

                    when (optionFood) {
                        1 -> handleFoodSelection(FoodType.PIZZA,newOrder)
                        2 -> handleFoodSelection(FoodType.HAMBURGER,newOrder)
                        3 -> handleFoodSelection(FoodType.SANDWICH,newOrder)
                        4 -> exitFoodMenu = true
                        else ->controller.message(Message.INVALID_DATA)

                    }
                }
            }

            2 -> {
                try {
                    controller.message(Message.REQUEST)
                    val orderNumber = scanner.nextLine().toIntOrNull()

                    if (orderNumber != null) {
                        controller.listOrderById(orderNumber)
                    } else {
                        controller.message(Message.INVALID_DATA)
                    }
                } catch (e: NoSuchElementException) {
                   controller.message(Message.INVALID_DATA)
                }
            }

            3 -> {
                controller.listAllOrders()
            }

            4 -> {
                try {
                    controller.message(Message.REQUEST)
                    val orderNumber = scanner.nextLine().toIntOrNull()

                    if (orderNumber != null) {
                        controller.removeOrderById(orderNumber)
                    }
                } catch (e: NoSuchElementException) {
                    controller.message(Message.INVALID_DATA)
                }
            }

            5 -> {
                controller.message(Message.EXIT)
                exit = true
            }

            else -> {
                controller.message(Message.INVALID_DATA)
            }
        }

    } while (!exit)
}
    // Función auxiliar para manejar la selección de comida
    fun handleFoodSelection(foodType: FoodType,order:Order) {
        val foodFactory = FoodFactory.createFactory(foodType)
        var food=foodFactory.createFood("")
        controller.updateView(TypeMenu.INGREDIENTS_MENU)
        val optionIngredients= scanner.nextLine().toIntOrNull()
        when (optionIngredients) {
            1 -> food=Cheese(food)
            2 -> food=Sauce(food)
            3 -> println("Sin ingredientes")
            else -> println("Opción no válida. Intenta de nuevo.")
        }
        order.addFoodToOrder(food)
    }



