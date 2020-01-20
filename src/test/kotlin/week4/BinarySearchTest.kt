package week4

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class BinarySearchTest {

    @Test
    fun `sample 1`() {
        val array = intArrayOf(1, 5, 8, 12, 13)
        assertThat(BinarySearch.binarySearch(array, 8)).isEqualTo(2)
        assertThat(BinarySearch.binarySearch(array, 1)).isEqualTo(0)
        assertThat(BinarySearch.binarySearch(array, 23)).isEqualTo(-1)
        assertThat(BinarySearch.binarySearch(array, 1)).isEqualTo(0)
        assertThat(BinarySearch.binarySearch(array, 11)).isEqualTo(-1)
    }

    @Test
    fun `sample 2`() {
        val array = intArrayOf(1, 2, 3, 4, 5)
        assertThat(BinarySearch.binarySearch(array, 1)).isEqualTo(0)
        assertThat(BinarySearch.binarySearch(array, 2)).isEqualTo(1)
        assertThat(BinarySearch.binarySearch(array, 3)).isEqualTo(2)
        assertThat(BinarySearch.binarySearch(array, 4)).isEqualTo(3)
        assertThat(BinarySearch.binarySearch(array, 5)).isEqualTo(4)
    }
}