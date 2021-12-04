
fun main() {

    fun part1(input: List<String>) {
        var gammaRate = ""
        val column = mutableListOf<Char>()

        for (index in input[0].indices) {
            for (value in input) {
                column.add(value[index])
            }
            val digit = if (column.count { it == '0' } > column.count { it == '1'}) '0' else '1'
            gammaRate += digit
            column.clear()
        }

        val epsilonRate = gammaRate
            .toCharArray()
            .map { if (it == '0') '1' else '0' }
            .joinToString("")

        val gammaRateInteger = Integer.parseInt(gammaRate, 2)
        val epsilonRateInteger = Integer.parseInt(epsilonRate, 2)

        println("Result : " + gammaRateInteger * epsilonRateInteger)
    }

    val testInput = readInput("Day03_data")
    part1(testInput)
}


