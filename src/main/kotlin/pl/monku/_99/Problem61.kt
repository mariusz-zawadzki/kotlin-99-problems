package pl.monku._99


fun <T> Tree<T>.leafCount(): Int = when {
    this == End -> 0
    this is Node -> if(isLeaf<T>()){
        1
    } else {
        this.left.leafCount() + this.right.leafCount()
    }
    else -> {
        throw IllegalArgumentException("Expected Node or End")
    }
}
fun <T> Tree<T>.leafValues(): List<T> = when {
    this == End -> listOf<T>()
    this is Node -> if(isLeaf<T>()){
        listOf(this.value)
    } else {
        this.left.leafValues() + this.right.leafValues()
    }
    else -> {
        throw IllegalArgumentException("Expected Node or End")
    }
}
fun <T> Tree<T>.internalValues(): List<T> = when {
    this == End -> listOf<T>()
    this is Node -> if(isLeaf<T>()){
        listOf()
    } else {
        listOf(this.value) + this.left.internalValues() + this.right.internalValues()
    }
    else -> {
        throw IllegalArgumentException("Expected Node or End")
    }
}

private fun <T> Node<T>.isLeaf() = this.left == this.right && this.left == End

fun main(args: Array<String>) {
    val allHBTreesWithNodeAmount = allHBTreesWithNodeAmount(4, "X")
    allHBTreesWithNodeAmount.forEach { it.leafCount().toString().print() }
    allHBTreesWithNodeAmount.toString().print()
}