import java.util.Scanner

class Menu {
    val scanner = Scanner(System.`in`)

    fun showMenu(title: String, items: List<MenuItem>): Boolean {
        while (true) {
            println(title)
            println()

            for (i in 0..(items.size-1)) {
                println("$i. ${items[i].name}")
            }
            println("${items.size}. Выход")

            val input = scanner.nextLine()
            val number = input.toIntOrNull()

            if (number == null) {
                println("Введите цифру из списка")
                continue
            }
            if (number == items.size) {
                return false
            }
            if (number < 0 || number > items.size) {
                println("В списке нет такой цифры, попробуйте ещё раз")
                continue
            }

            items[number].action()
            return true
        }
    }

    fun readText(message: String): String {
        while (true) {
            println(message)
            val text = scanner.nextLine()
            if (text.isBlank()) {
                println("Ввели пустое значение, попробуйте ещё раз")
                continue
            }
            return text
        }
    }
}