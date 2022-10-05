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

fun get_price(nRows: Int, seatsPerRow: Int, row: Int, seat: Int): Int {
    val totalSeats = nRows * seatsPerRow
    if (totalSeats <= SIZE_THRESHOLD || (row <= nRows / 2) ) {
        return EXPENSIVE
    }
    return CHEAP
}

fun print_room(nRows: Int, seatsPerRow: Int, row: Int, seat: Int):Unit {
    println("Cinema:")
    print(" ")
    for (s in 1..seatsPerRow) {
        print(" $s")
    }
    println()
    for (r in 1..nRows) {
        print("$r")
        for (s in 1..seatsPerRow) {
            if (r == row && s == seat) {
                print(" B")
            } else {
                print(" S")
            }
        }
        println()
    }
}


fun main() {
    println("Enter the number of rows:")
    val nRows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seatsPerRow = readln().toInt()
    print_room(nRows, seatsPerRow, -1, -1)
    println("Enter a row number:")
    val row = readln().toInt()
    println("Enter a seat number in that row:")
    val seat = readln().toInt()
    println("Ticket price: \$${get_price(nRows, seatsPerRow, row, seat)}")
    print_room(nRows, seatsPerRow, row, seat)
}