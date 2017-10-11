package pl.monku._99

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class Problem56KtTest {
    @Test
    fun `should tell properly if tree is symetric`(){
        assertTrue(Node("a", Node("b"), Node("c")).isSymetric())
        assertFalse(Node("a", Node("c")).isSymetric())
        assertTrue(End.isSymetric())
    }
}