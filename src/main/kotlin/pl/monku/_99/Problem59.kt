package pl.monku._99


//
fun <T> balancedHeightTrees(height: Int, element: T): List<Tree<T>> {
    if (height == 0) {
        return listOf(End)
    } else if (height == 1) {
        return listOf(Node(element))
    } else {
        return subHeightBalanced(height, element)
    }
}

fun <T> Tree<T>.height(): Int {
    return if(this is Node) {
        Math.max(left.height(), right.height())+1
    } else {
        0
    }
}

fun <T> subHeightBalanced(height: Int, element: T): List<Tree<T>> {
    if (height == 0) {
        return listOf(End)
    } else if (height == 1) {
        return listOf(Node(element), End)
    } else {
        val balancedLeft = subHeightBalanced(height - 1, element)
        val balancedRight = subHeightBalanced(height - 1, element)
        val distinct = balancedLeft.flatMap { left ->
            balancedRight.flatMap { right ->
                if(left == End && right == End){
                    listOf()
                }
                else{
                    listOf(Node(element, left, right), Node(element, right, left))
                }
            }
        }.distinct()
        return distinct
    }
}

fun main(args: Array<String>) {
    balancedHeightTrees(2, "X").toString().print()
}