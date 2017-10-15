package pl.monku._99


//
fun <T> balancedHeightTrees(height: Int, element: T): List<Tree<T>> = when (height) {
    0 -> listOf(End)
    1 -> listOf(Node(element))
    else -> subHeightBalanced(height, element)
}

fun <T> Tree<T>.height(): Int = when {
    this !is Node -> 0
    else -> 1 + Math.max(left.height(), right.height())
}

fun <T> subHeightBalanced(height: Int, element: T): List<Tree<T>> {
    when (height) {
        0 -> return listOf(End)
        1 -> return listOf(Node(element), End)
        else -> {
            val balancedLeft = subHeightBalanced(height - 1, element)
            return balancedLeft.flatMap { left ->
                balancedLeft.flatMap { right ->
                    if (left == End && right == End) {
                        listOf()
                    } else {
                        listOf(Node(element, left, right), Node(element, right, left))
                    }
                }
            }.distinct()
        }
    }
}