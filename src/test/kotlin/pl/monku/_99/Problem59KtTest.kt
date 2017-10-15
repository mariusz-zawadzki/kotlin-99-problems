package pl.monku._99

import org.hamcrest.CoreMatchers
import org.junit.Assert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Test

class Problem59KtTest {

    @Test
    fun `should return balanced tree`() {
        IntRange(1, 5).forEach {
            val n = it
            val balancedTrees = balancedHeightTrees(it, "X")
            balancedTrees.flatMap {
                it.nodes()
            }.forEach { node ->
                assertTrue(node.left.height() - node.right.height() <= 1)
            }
            balancedTrees.forEach {
                assertThat(it.height(), CoreMatchers.equalTo(n))
            }

        }
    }
}

