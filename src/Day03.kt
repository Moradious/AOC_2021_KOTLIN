
fun main() {

    fun part1(input: List<String>) {
        var gammaRate = ""
        var column: List<Char>

        for (index in input[0].indices) {
            column = input.map { it[index] }
            val digit = if (column.count { it == '0' } > (column.size / 2)) '0' else '1'
            gammaRate += digit
        }

        val epsilonRate = gammaRate
            .toCharArray()
            .map { if (it == '0') '1' else '0' }
            .joinToString("")

        val gammaRateInteger = Integer.parseInt(gammaRate, 2)
        val epsilonRateInteger = Integer.parseInt(epsilonRate, 2)

        println("Result part1 : " + gammaRateInteger * epsilonRateInteger)
    }

    fun part2(input: List<String>) {

        var oxygenRating = input.map { it }
        var scruberRating = input.map { it }

        loop@ for (index in oxygenRating[0].indices) {
            oxygenRating
                .map { it[index] }
                .partition { it == '0' }
                .apply {
                    oxygenRating = if (first.size > second.size) {
                        oxygenRating.filter { it[index] == '0' }
                    } else {
                        oxygenRating.filter { it[index] == '1' }
                    }
                }

            if (oxygenRating.size == 1) break@loop
        }

        loop@ for (index in scruberRating[0].indices) {
                scruberRating
                    .map { it[index] }
                    .partition { it == '0' }
                    .apply {
                        scruberRating = if (first.size > second.size) {
                            scruberRating.filter { it[index] == '1' }
                        } else {
                            scruberRating.filter { it[index] == '0' }
                        }
                    }

            if (scruberRating.size == 1) break@loop
        }

        val result = Integer.parseInt(oxygenRating[0], 2) * Integer.parseInt(scruberRating[0], 2)
        println("Result : $result")
    }

    val testInput = readInput("Day03_data")
    part1(testInput)
    part2(testInput)
}


