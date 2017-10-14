package pl.monku._99

interface Tree<out T>

data class Node<out T>(val value: T, val left: Tree<T> = End, val right: Tree<T> = End) : Tree<T> {
    override fun toString(): String {
        val children = if (left == End && right == End) "" else " $left $right"
        return "T($value$children)"
    }
}

val End = object : Tree<Nothing>{
    override fun toString() = "."
}


fun <T> Tree<T>.nodes(): List<Node<T>> = when {
    this is Node<T> -> left.nodes() + right.nodes() + this
    else -> emptyList()
}

fun <T> Tree<T>.nodesCount(): Int = this.nodes().filter { it != End }.size
