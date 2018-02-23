package pl.monku._99

import org.junit.Assert
import org.junit.Test

class Problem61KtTest {

    @Test
    fun leafCount() {
        Assert.assertEquals(x(x(), x(x(), x())).leafCount(), 3)
        Assert.assertEquals(x(x(x(x(), x()), x()), x(x(), x())).leafCount(), 5)
    }

    @Test
    fun leafValues() {
        Assert.assertEquals(Node(1, Node(2, Node(3), Node(4)), Node(5)).leafValues(), listOf(3, 4, 5))
        Assert.assertEquals(Node(1, Node(2, Node(3, Node(6)), Node(4)), Node(5, Node(7), Node(8))).leafValues(), listOf(6, 4, 7, 8))
    }

    @Test
    fun internalValues() {
        Assert.assertEquals(Node(1, Node(2, Node(3), Node(4)), Node(5)).internalValues(), listOf(1, 2))
        Assert.assertEquals(Node(1, Node(2, Node(3, Node(6)), Node(4)), Node(5, Node(7), Node(8))).internalValues(), listOf(1, 2, 3, 5))
    }

}