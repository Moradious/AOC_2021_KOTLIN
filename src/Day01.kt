
fun main() {

    fun part1(input: List<Int>): Int {
        return input.windowed(2).count { it[0] < it[1] }
    }

    fun part2(input: List<Int>): Int {
        return input
            .windowed(3) { it.sum() }
            .windowed(2)
            .count { it[0] < it[1] }
    }

    val testInput = readInput("Day01_test").map { it.toInt() }
    println(part1(testInput))
    println(part2(testInput))
}
