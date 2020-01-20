package week3

import org.junit.Test

import org.assertj.core.api.Assertions.*

class LargestNumberTest {

    @Test
    fun `sample 1`() {
        var num = largestNumber(mutableListOf("21", "2"))
        assertThat(num).isEqualTo("221")

        num = largestNumber(mutableListOf("3", "31"))
        assertThat(num).isEqualTo("331")

        num = largestNumber(mutableListOf("3", "32"))
        assertThat(num).isEqualTo("332")

        num = largestNumber(mutableListOf("3", "33"))
        assertThat(num).isEqualTo("333")

        num = largestNumber(mutableListOf("3", "34"))
        assertThat(num).isEqualTo("343")
    }

    @Test
    fun `sample 2`() {
        val num = largestNumber(mutableListOf("9", "4", "6", "1", "9"))
        assertThat(num).isEqualTo("99641")
    }

    @Test
    fun `sample 3`() {
        val num = largestNumber(mutableListOf("23", "39", "92"))
        assertThat(num).isEqualTo("923923")
    }

    @Test
    fun test0() {
        val num = largestNumber(mutableListOf("123", "1"))
        assertThat(num).isEqualTo("1231")
    }

    @Test
    fun test1() {
        val num = largestNumber(mutableListOf("79", "7"))
        assertThat(num).isEqualTo("797")
    }

    @Test
    fun test4() {
        var num = largestNumber(mutableListOf("3", "372"))
        assertThat(num).isEqualTo("3723")
    }

    @Test
    fun test5() {
        var num = largestNumber(mutableListOf("98", "9900"))
        assertThat(num).isEqualTo("990098")
    }

    @Test
    fun test2() {
        var num = largestNumber(mutableListOf("3", "314"))
        assertThat(num).isEqualTo("3314")
    }

    @Test
    fun test3() {
        var num = largestNumber(mutableListOf("33", "33", "3134"))
        assertThat(num).isEqualTo("33333134")

        num = largestNumber(mutableListOf("99", "98", "990"))
        assertThat(num).isEqualTo("9999098")

        num = largestNumber(mutableListOf("12", "21"))
        assertThat(num).isEqualTo("2112")
    }
}
