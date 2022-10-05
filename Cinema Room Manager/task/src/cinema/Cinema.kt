package cinema

const val EXPENSIVE = 10
const val CHEAP = 8
const val SIZE_THRESHOLD = 60


fun profit(nRows: Int, seatsPerRow: Int): Int {
    val totalSeats = nRows * seatsPerRow
    if (totalSeats <= SIZE_THRESHOLD) {
        return totalSeats * EXPENSIVE
    }
    val frontHalfSeats = nRows / 2 * seatsPerRow
    val backHalfSeats = (nRows - nRows / 2) * seatsPerRow
    return  frontHalfSeats * EXPENSIVE + backHalfSeats * CHEAP
}

fun buyTicket(room: MutableList<MutableList<String>>) {
    val nRows = room.size
    val seatsPerRow = room[0].size
    val totalSeats = nRows * seatsPerRow
    var price = CHEAP

    println("Enter a row number:")
    val row = readln().toInt()
    println("Enter a seat number in that row:")
    val seat = readln().toInt()

    if (totalSeats <= SIZE_THRESHOLD || (row <= nRows / 2) ) {
        price = EXPENSIVE
    }

    println("Ticket price: \$${price}")
    room[row - 1][seat - 1] = "B"
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
        0. Exit""".trimIndent()
        )
        val command = readln().toInt()
        when (command) {
            1 -> showSeats(room)
            2 -> buyTicket(room)
            0 -> break
        }
    }
}