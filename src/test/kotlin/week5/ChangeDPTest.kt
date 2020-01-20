package week5

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ChangeDPTest {

    @Test
    fun `sample 1`() {
        val n = ChangeDP().getChange(2)
        assertThat(n).isEqualTo(2)
    }

    @Test
    fun `sample 2`() {
        val n = ChangeDP().getChange(34)
        assertThat(n).isEqualTo(9)
    }
}