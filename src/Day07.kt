import kotlin.math.max
import kotlin.math.min

fun main() {

    fun part1(input: List<Int>): Int? =
        input
            .map { number -> input.map { entry -> max(number, entry) - min(number, entry) }.sum() }
            .minOrNull()

    fun part2(input: List<Int>): Int? =
        input
            .map { number -> input.map { entry -> getTriangularNumber((max(number, entry) - min(number, entry))) }.sum() }
            .minOrNull()

    val testInput = readInput("Day07_data")
    val data = testInput[0].split(",").map { it.toInt() }
    println(part1(data))
    println(part2(data))
}

fun getTriangularNumber(moves: Int): Int = moves * (moves + 1) / 2

