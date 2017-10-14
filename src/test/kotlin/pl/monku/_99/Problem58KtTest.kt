package pl.monku._99

import org.hamcrest.CoreMatchers
import org.junit.Assert.assertThat
import org.junit.Test

class Problem58KtTest {

    @Test
    fun `should return only symentric balanced trees`() {

        assertThat(symmetricBalancedTrees(0, "x").size, CoreMatchers.equalTo(1))
        assertThat(symmetricBalancedTrees(0, "x").get(0) as Tree<Nothing>, CoreMatchers.equalTo(End))
        assertThat(symmetricBalancedTrees(1, "x"), ContainsAll(listOf(x())))
        assertThat(symmetricBalancedTrees(2, "x").size, CoreMatchers.equalTo(0))
        assertThat(symmetricBalancedTrees(3, "x"), ContainsAll(listOf(x(x(), x()))))
        assertThat(symmetricBalancedTrees(4, "x").size, CoreMatchers.equalTo(0))
        assertThat(symmetricBalancedTrees(5, "x"), ContainsAll(listOf(
                x(x(l = End, r = x()), x(l = x(), r = End)),
                x(x(l = x(), r = End), x(l = End, r = x()))
        )))
    }
}