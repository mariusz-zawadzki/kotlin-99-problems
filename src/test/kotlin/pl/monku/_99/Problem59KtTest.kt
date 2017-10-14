package pl.monku._99

import org.junit.Assert.assertTrue
import org.junit.Test

class Problem59KtTest {

    @Test
    fun `should return balanced tree`() {
        IntRange(1, 29).forEach {
            balancedTrees(it, "X").flatMap {
                it.nodes()
            }.forEach { node ->
                assertTrue(node.left.height() - node.right.height() <= 1)
            }
        }
    }
}

