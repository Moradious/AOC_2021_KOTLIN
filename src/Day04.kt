
fun main() {

    fun part1(numbers: List<String>, boards: MutableList<List<List<Number>>>) {

        run loop@{
            numbers.forEach { number ->
                boards.flatten().flatten().forEach {
                    if (it.value == number) it.marked = true
                }
                if (checkCompleteRowOrColumn(number, boards)) return@loop
            }
        }
    }

    val testInput = readInput("Day04_data")
    val numbers = testInput[0].split(",")
    val boards = getBoards(testInput)
    part1(numbers, boards)
}

data class Number(val value: String, var marked: Boolean)

private fun getBoards(testInput: List<String>): MutableList<List<List<Number>>> {
    val boards = mutableListOf<List<List<Number>>>()
    val board = mutableListOf<List<Number>>()
    for (i in 2 until testInput.size) {
        if (testInput[i].isNotEmpty()) {
            board.add(
                testInput[i].split(" ").filter { it.isNotBlank() }.map { Number(it, false) }
            )
        } else {
            boards.add(board.map {it})
            board.clear()
        }
    }

    return boards
}

fun checkCompleteRowOrColumn(numberEntry: String, boards: MutableList<List<List<Number>>>): Boolean {

    boards.forEachIndexed { index, board ->
        board.forEach { row ->
            if (isWinningBoard(numberEntry, board, row, index)) return true
        }

        for (i in 0..4) {
            val column = board.map { it[i] }
            if (isWinningBoard(numberEntry, board, column, index)) return true
        }
    }

    return false
}

fun isWinningBoard(numberEntry: String, board: List<List<Number>>, rowOrColumn: List<Number>, index: Int): Boolean {
    var isFinished = true
    rowOrColumn.forEach inner@{ number ->
        if (number.marked) {
            return@inner
        } else {
            isFinished = false
        }
    }
    if (isFinished) {
        println("result : $index")
        computeBoard(numberEntry, board)
        return true
    }

    return false
}

fun computeBoard(numberEntry: String, board: List<List<Number>>) {
    val unMarked = board
            .flatten()
            .filter { !it.marked }
            .map { it.value.toInt()}
            .fold(0) { acc, number ->  acc + number}

    val score = unMarked * numberEntry.toInt()
    println("Score : $score")
}
