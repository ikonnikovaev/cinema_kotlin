package cinema

const val EXPENSIVE = 10
const val CHEAP = 8
const val SIZE_THRESHOLD = 60


fun statInfo(room: MutableList<MutableList<String>>) {
    val nRows = room.size
    val seatsPerRow = room[0].size
    val totalSeats = nRows * seatsPerRow
    var purchasedTickets = 0
    var currentProfit = 0
    var possibleProfit = 0
    for (r in 1..nRows) {
        for (s in 1..seatsPerRow) {
            var price = CHEAP
            if (totalSeats <= SIZE_THRESHOLD || (r <= nRows / 2) ) {
                price = EXPENSIVE
            }
            possibleProfit += price
            if (room[r - 1][s - 1] == "B") {
                purchasedTickets += 1
                currentProfit += price
            }
        }
    }
    val percentage = (purchasedTickets.toDouble() / totalSeats) * 100
    println("Number of purchased tickets: $purchasedTickets")
    println("Percentage: ${"%.2f".format(percentage)}%")
    println("Current income: \$$currentProfit")
    println("Total income: \$$possibleProfit")
}

fun buyTicket(room: MutableList<MutableList<String>>) {
    val nRows = room.size
    val seatsPerRow = room[0].size
    val totalSeats = nRows * seatsPerRow
    var price = CHEAP


    while (true) {
        println("Enter a row number:")
        val row = readln().toInt()
        println("Enter a seat number in that row:")
        val seat = readln().toInt()
        if (row <= 0 || row > nRows || seat <= 0 || seat > seatsPerRow) {
            println("Wrong input!")
            continue
        }
        if (room[row - 1][seat - 1] == "B") {
            println("That ticket has already been purchased!")
            continue
        }
        if (totalSeats <= SIZE_THRESHOLD || (row <= nRows / 2) ) {
            price = EXPENSIVE
        }
        println("Ticket price: \$${price}")
        room[row - 1][seat - 1] = "B"
        break
    }
}

fun showSeats(room: MutableList<MutableList<String>>) {
    val nRows = room.size
    val seatsPerRow = room[0].size
    println("Cinema:")
    print(" ")
    for (s in 1..seatsPerRow) {
        print(" $s")
    }
    println()
    for (r in 1..nRows) {
        print("$r ")
        println(room[r - 1].joinToString(" "))
    }

}


fun main() {
    println("Enter the number of rows:")
    val nRows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seatsPerRow = readln().toInt()
    val room = MutableList(nRows) { MutableList(seatsPerRow) { "S" } }
    while (true) {
        println(
            """
        1. Show the seats
        2. Buy a ticket
        3. Statistics
        0. Exit""".trimIndent()
        )
        val command = readln().toInt()
        when (command) {
            1 -> showSeats(room)
            2 -> buyTicket(room)
            3 -> statInfo(room)
            0 -> break
        }
    }
}