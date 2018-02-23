package pl.monku._99

import org.junit.Assert
import org.junit.Test

class Problem62KtTest {

    @Test
    fun `should return values at level`() {
        Assert.assertEquals(listOf(1), Node (1, Node(2, Node(3), Node(4)), Node(5)).valuesAtLevel(0))
        Assert.assertEquals(listOf(2, 5), Node(1, Node(2, Node(3), Node(4)), Node(5)).valuesAtLevel(1))
        Assert.assertEquals(listOf(3, 4, 7, 8), Node(1, Node(2, Node(3, Node(6)), Node(4)), Node(5, Node(7), Node(8))).valuesAtLevel(2))
    }
}