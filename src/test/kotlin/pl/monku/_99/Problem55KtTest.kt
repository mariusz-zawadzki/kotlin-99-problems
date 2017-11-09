package pl.monku._99

import kotlinx.coroutines.experimental.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.hasItems
import org.junit.Assert.*
import org.junit.Test

fun x(l : Tree<String> =  End, r : Tree<String> = End): Tree<String> = Node("x", l,r)

class P55Test {


    @Suppress("UNCHECKED_CAST")
    @Test
    fun `construct all balanced trees`() {
        assertThat(balancedTrees(0, "x").size, equalTo(1))
        assertThat(balancedTrees(0, "x")[0] as Tree<Nothing>, equalTo(End))
        assertThat(balancedTrees(1, "x"), hasItems(x()))
        val listOf = listOf(
                x(l= End, r = x()),
                x(l = x(), r = End)
        )
        assertThat(balancedTrees(2, "x"), equalTo(listOf))
        assertThat(balancedTrees(3, "x"), equalTo(listOf(x(x(),x()))))
        assertThat(balancedTrees(4, "x"), equalTo(listOf(
                x(x(l=End, r=End),x(l=End, r=x())),
                x(x(l=End, r=x()),x(l=End, r=End)),
                x(x(l=End, r=End),x(l=x(), r=End)),
                x(x(l=x(), r=End),x(l=End, r=End))
        )))
        assertThat(balancedTrees(5, "x"), equalTo(listOf(
                x(x(l = End, r = x()),x(l = End, r = x())),
                x(x(l = End, r = x()),x(l = x(), r = End)),
                x(x(l = x(), r = End),x(l = End, r = x())),
                x(x(l = x(), r = End),x(l = x(), r = End))
        )))
    }

    @Suppress("UNCHECKED_CAST")
    @Test
    fun `construct all balanced trees with cooroutine implementation`() {
        runBlocking {

            assertThat(balancedTreesCooroutines(0, "x").size, equalTo(1))
            assertThat(balancedTreesCooroutines(0, "x")[0] as Tree<Nothing>, equalTo(End))
            assertThat(balancedTreesCooroutines(1, "x"), hasItems(x()))
            val listOf = listOf(
                    x(l = End, r = x()),
                    x(l = x(), r = End)
            )
            assertThat(balancedTreesCooroutines(2, "x"), equalTo(listOf))
            assertThat(balancedTreesCooroutines(3, "x"), equalTo(listOf(x(x(), x()))))
            assertThat(balancedTreesCooroutines(4, "x"), equalTo(listOf(
                    x(x(l = End, r = End), x(l = End, r = x())),
                    x(x(l = End, r = x()), x(l = End, r = End)),
                    x(x(l = End, r = End), x(l = x(), r = End)),
                    x(x(l = x(), r = End), x(l = End, r = End))
            )))
            assertThat(balancedTreesCooroutines(5, "x"), equalTo(listOf(
                    x(x(l = End, r = x()), x(l = End, r = x())),
                    x(x(l = End, r = x()), x(l = x(), r = End)),
                    x(x(l = x(), r = End), x(l = End, r = x())),
                    x(x(l = x(), r = End), x(l = x(), r = End))
            )))
        }
    }

    companion object {
        fun nodeList(vararg nodes: Node<String>): Iterable<Tree<String>> = nodes.asList()
    }
}