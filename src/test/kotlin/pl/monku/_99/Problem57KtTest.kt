package pl.monku._99

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.Test

class Problem57KtTest{
    @Test
    fun `should add properly to empty node`(){
        assertThat(End.add("1"), equalTo(Node("1") as Tree<String>))
    }

    @Test
    fun `should add properly to multiple nodes`(){
        assertThat(End.add(1).add(2).add(3), equalTo(Node(1, right = Node(2, right = Node(3))) as Tree<Int>))
        assertThat(End.add(2).add(1).add(3), equalTo(Node(2, Node(1), Node(3)) as Tree<Int>))
    }

    @Test
    fun `should create proper tree from a list`() {
        assertThat(listOf(1,2,3).toTree(), equalTo(Node(1, right = Node(2, right = Node(3))) as Tree<Int>))
        assertThat(listOf(2,1,3).toTree(), equalTo(Node(2, Node(1), Node(3)) as Tree<Int>))
        assertThat(listOf(2,3,1).toTree(), equalTo(Node(2, Node(1), Node(3)) as Tree<Int>))
    }
}


