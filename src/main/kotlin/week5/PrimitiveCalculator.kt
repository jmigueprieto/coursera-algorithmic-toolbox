package week5

import java.util.*

class PrimitiveCalculator {

    private val operations = listOf<(Int) -> Int>(
        { i -> i * 2 }, { i -> i * 3 }, { i -> i + 1 }
    )

    fun optimalSequence(desiredNumber: Int): List<Int> {
        if (desiredNumber == 1) {
            return listOf(1)
        }

        val numbers = IntArray(desiredNumber + 1)
        val newNumbers = mutableListOf(1)
        numbers[1] = 0
        loop@ while (newNumbers.isNotEmpty()) {
            val numbersToAnalyze = newNumbers.toTypedArray()
            newNumbers.clear()
            for (n in numbersToAnalyze) {
                for (op in operations) {
                    val newNumber = op(n)
                    if (newNumber <= desiredNumber) {
                        if (numbers[newNumber] == 0) {
                            numbers[newNumber] = n
                            newNumbers += newNumber
                        }

                        if (newNumber == desiredNumber) {
                            break@loop
                        }
                    }
                }
            }

        }

        val sequence = mutableListOf<Int>()
        var n = desiredNumber
        while (n >= 1) {
            sequence += n
            n = numbers[n]
        }

        return sequence.reversed()
    }
}


fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val sequence = PrimitiveCalculator().optimalSequence(n)
    println(sequence.size - 1)
    sequence.forEach { x -> print("$x ") }
}