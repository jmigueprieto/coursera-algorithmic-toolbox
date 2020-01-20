package week6

import java.util.*

class GoldKnapsack(private val weight: Int, private val items: IntArray) {

    private val matrix = Array(items.size + 1) { Array(weight + 1) { 0 } }

    private fun compute(): Int {
        val n = items.size
        for (i in 1..n) {
            for (w in 1..weight) {
                matrix[i][w] = matrix[i - 1][w]
                if (items[i - 1] <= w) {
                    val candidate = matrix[i - 1][w - items[i - 1]] + items[i - 1]
                    if (candidate > matrix[i][w]) {
                        matrix[i][w] = candidate
                    }
                }
            }
        }
        return matrix[n][weight]
    }

    //
    // Public members
    //
    val value = compute()
}


fun main() {
    val scanner = Scanner(System.`in`)
    val w: Int
    val n: Int
    w = scanner.nextInt()
    n = scanner.nextInt()
    val array = IntArray(n)
    for (i in 0 until n) {
        array[i] = scanner.nextInt()
    }
    println(GoldKnapsack(w, array).value)
}