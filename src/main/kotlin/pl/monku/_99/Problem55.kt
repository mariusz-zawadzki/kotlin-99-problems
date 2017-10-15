package pl.monku._99

fun main(args: Array<String>) {
    balancedTrees(4, "X").toString().print()
}

//
fun <T> balancedTrees(nodes: Int, element: T): List<Tree<T>> {
    if (nodes == 0) {
        return listOf(End)
    } else if (nodes == 1) {
        return listOf(Node(element))
    } else {
        val n = (nodes - 1) / 2
        val balancedLeft = balancedTrees(n, element)
        val balancedRight = balancedTrees(nodes - 1 - n, element)
        return balancedLeft.flatMap { left ->
            balancedRight.flatMap { right ->
                listOf(Node(element, left, right), Node(element, right, left))
            }
        }.distinct()


    }
}

