package week6

import org.assertj.core.api.Assertions.*
import org.junit.Test

class PlacingParenthesesTest {

    @Test
    fun `sample 1`() {
        val result = PlacingParentheses("1+5").getMaxValue()
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `sample 2`() {
        val result = PlacingParentheses("5-8+7*4-8+9").getMaxValue()
        assertThat(result).isEqualTo(200)
    }

}