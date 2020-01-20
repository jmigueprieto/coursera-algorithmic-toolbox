package week4

import java.util.*

fun getNumberOfInversions(a: IntArray, b: IntArray, left: Int, right: Int): Long {
    var numberOfInversions: Long = 0
    if (right <= left + 1) {
        return numberOfInversions
    }
    val middle = (left + right) / 2
    numberOfInversions += getNumberOfInversions(a, b, left, middle)
    numberOfInversions += getNumberOfInversions(a, b, middle, right)

    val inversions = merge(a, left, middle, right)
    numberOfInversions += inversions
    return numberOfInversions
}

fun merge(array: IntArray, left: Int, middle: Int, right: Int): Int {
    var inversions = 0
    val sorted = IntArray(right - left)
    var aIndex = left
    var bIndex = middle
    var i = 0
    while (i < sorted.size) {
        if (aIndex < middle && bIndex < right) {
            val aValue = array[aIndex]
            val bValue = array[bIndex]
            if (aValue > bValue) {
                sorted[i++] = bValue
                inversions += (middle - aIndex)
                ++bIndex
            } else {
                sorted[i++] = aValue
                ++aIndex
            }
        } else {
            if (aIndex < middle) {
                sorted[i++] = array[aIndex++]
            } else {
                sorted[i++] = array[bIndex++]
            }
        }
    }

    for (ii in sorted.indices) {
        array[ii + left] = sorted[ii]
    }

    return inversions
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = scanner.nextInt()
    }
    val b = IntArray(n)
    println(getNumberOfInversions(a, b, 0, a.size))
}