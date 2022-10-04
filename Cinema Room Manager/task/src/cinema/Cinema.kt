package cinema

fun profit(nRows: Int, seatsPerRow: Int): Int {
    val expensive = 10
    val cheap = 8
    val threshold = 60
    val totalSeats = nRows * seatsPerRow
    if (totalSeats <= threshold) {
        return totalSeats * expensive
    }
    val frontHalfSeats = nRows / 2 * seatsPerRow
    val backHalfSeats = (nRows - nRows / 2) * seatsPerRow
    return  frontHalfSeats * expensive + backHalfSeats * cheap
}


fun main() {
    println("Enter the number of rows:")
    val nRows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seatsPerRow = readln().toInt()
    val result = profit(nRows, seatsPerRow)
    println("Total income:")
    println("\$$result")


    /*
    println("Cinema:")
    println("  1 2 3 4 5 6 7 8")
    println("1 S S S S S S S S")
    println("2 S S S S S S S S")
    println("3 S S S S S S S S")
    println("4 S S S S S S S S")
    println("5 S S S S S S S S")
    println("6 S S S S S S S S")
    println("7 S S S S S S S S") */
}