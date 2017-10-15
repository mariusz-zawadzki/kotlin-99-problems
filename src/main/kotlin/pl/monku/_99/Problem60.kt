package pl.monku._99

fun minNodeAmountInHBTree(height: Int): Int = 2.pow(height-1)

fun maxHeightOfHBTree(nodeAmount : Int ): Int {
    var height = 0
    while (minNodeAmountInHBTree(height) <= nodeAmount) {
        height++
    }
    return height-1
}

fun <T> allHBTreesWithNodeAmount(nodes: Int, element:T): List<Tree<T>> = balancedHeightTrees(maxHeightOfHBTree(nodes), element).filter { it.nodesCount() == nodes }


fun main(args: Array<String>){
    maxHeightOfHBTree(1).toString().print()
    maxHeightOfHBTree(2).toString().print()
    maxHeightOfHBTree(4).toString().print()
    maxHeightOfHBTree(7).toString().print()
    maxHeightOfHBTree(8).toString().print()
    maxHeightOfHBTree(15).toString().print()
    maxHeightOfHBTree(16).toString().print()
}