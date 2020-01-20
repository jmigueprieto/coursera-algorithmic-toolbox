import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min
import kotlin.math.roundToLong

data class Item(val value: Int, val weight: Int, val valuePerUnit: Double, var used: Boolean = false)

fun getOptimalValue(capacity: Int, values: IntArray, weights: IntArray): Double {
    var remainingCapacity = capacity
    var optimalValue = 0.0
    val items = getItems(values, weights)

    for (i in 0 until items.size) {
        if (remainingCapacity == 0) {
            return optimalValue
        }

        val item = items.filter { !it.used }.maxBy { it.valuePerUnit } ?: return optimalValue
        val units = min(item.weight, remainingCapacity)
        item.used = true
        remainingCapacity -= units
        optimalValue += units * item.valuePerUnit
    }

    return (optimalValue * 10000).roundToLong() / 10000.0
}

private fun getItems(values: IntArray, weights: IntArray): ArrayList<Item> {
    val items = ArrayList<Item>()
    for (i in 0 until values.size) {
        items.add(
            Item(
                value = values[i],
                weight = weights[i],
                valuePerUnit = values[i].toDouble() / weights[i]
            )
        )
    }
    return items
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val capacity = scanner.nextInt()
    val values = IntArray(n)
    val weights = IntArray(n)
    for (i in 0 until n) {
        values[i] = scanner.nextInt()
        weights[i] = scanner.nextInt()
    }
    println(getOptimalValue(capacity, values, weights))
}