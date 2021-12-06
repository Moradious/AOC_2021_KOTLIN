import kotlin.math.max
import kotlin.math.min

val coordinates = mutableMapOf<Pair<Int, Int>, Int>()

fun main() {

    fun part1(input: List<List<String>>): Int {
        input.forEach {
            when {
                it[0] == it[2] -> {
                    updateCoordinates(it[0].toInt(), null, it[1].toInt(), it[3].toInt())
                }
                it[1] == it[3] -> {
                    updateCoordinates(null, it[1].toInt(), it[0].toInt(), it[2].toInt())
                }
                else -> {
                    // do nothing
                }
            }
        }

        return coordinates.count { it.value > 1 }
    }

    fun part2(input: List<List<String>>): Int {
        input.forEach {
            when {
                it[0] == it[2] -> {
                    updateCoordinates(it[0].toInt(), null, it[1].toInt(), it[3].toInt())
                }
                it[1] == it[3] -> {
                    updateCoordinates(null, it[1].toInt(), it[0].toInt(), it[2].toInt())
                }
                else -> {
                    updateDiagonalCoordinates(it[0].toInt(), it[1].toInt(), it[2].toInt(), it[3].toInt())
                }
            }
        }

        return coordinates.count { it.value > 1 }
    }

    val testInput = readInput("Day05_data")
    val data = testInput.map { it.replace(" -> ", ",").split(",") }

    println(part1(data))
    println(part2(data))
}

fun updateCoordinates(baseX: Int?, baseY: Int?, oneEnd: Int, otherEnd: Int) {

    for (i in min(oneEnd, otherEnd)..max(oneEnd, otherEnd)) {
        val coordinate = Pair(baseX ?: i, baseY ?: i)
        if (coordinates.containsKey(coordinate)) {
            coordinates[coordinate] = coordinates[coordinate]!!.plus(1)
        } else {
            coordinates[coordinate] = 1
        }
    }
}

fun updateDiagonalCoordinates(x1: Int, y1: Int, x2:Int, y2: Int) {
    val list = listOf(Pair(x1, y1), Pair(x2, y2))
    list.forEach { coordinate ->
        if (coordinates.containsKey(coordinate)) {
            coordinates[coordinate] = coordinates[coordinate]!!.plus(1)
        } else {
            coordinates[coordinate] = 1
        }
    }

    // to do
}
