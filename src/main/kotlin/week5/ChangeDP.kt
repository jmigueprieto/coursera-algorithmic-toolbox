package week5

import java.util.*

class ChangeDP {

    fun getChange(money: Int): Int {
        val coins = listOf(1, 3, 4)
        val minNumCoins = IntArray(money + 1) { Int.MAX_VALUE }
        minNumCoins[0] = 0
        (1..money).forEach { m ->
            for (coin in coins) {
                if (m >= coin) {
                    val numCoins = minNumCoins[m - coin] + 1
                    if (numCoins < minNumCoins[m]) {
                        minNumCoins[m] = numCoins
                    }
                }
            }
        }
        return minNumCoins[money]
    }

}

fun main() {
    val scanner = Scanner(System.`in`)
    val m = scanner.nextInt()
    println(ChangeDP().getChange(m))
}