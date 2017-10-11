package pl.monku._99

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class Problem56KtTest {
    @Test
    fun `should tell properly if tree is symetric`(){
        assertTrue(Node("a", Node("b"), Node("c")).isSymmetric())
        assertFalse(Node("a", Node("c")).isSymmetric())
        assertTrue(End.isSymmetric())
    }
}