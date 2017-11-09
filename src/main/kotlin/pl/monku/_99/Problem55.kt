package pl.monku._99

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking
import kotlin.coroutines.experimental.buildSequence
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val nodes = 127+129
    val time = measureTimeMillis {
        balancedTrees(nodes, "X").size.toString().print()
    }
    val timeCooroutines = measureTimeMillis {
        runBlocking {
            balancedTreesCooroutines(nodes, "X").size.toString().print()
        }
    }

    println("normal      took $time ms")
    println("cooroutines took $timeCooroutines ms")
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
        val mapped = HashSet<Pair<Tree<T>,Tree<T>>>()
        val flatMap = balancedLeft.flatMap { left ->
            balancedRight.flatMap { right ->
                flatMapTree(mapped, left, right, element)
            }
        }
        return flatMap
    }
}

suspend fun <T> balancedTreesCooroutines(nodes: Int, element: T): List<Tree<T>> {
    if (nodes == 0) {
        return listOf(End)
    } else if (nodes == 1) {
        return listOf(Node(element))
    } else {
        val n = (nodes - 1) / 2

        val asyncBalancedLeft = async(CommonPool) {
            balancedTreesCooroutines(n, element)
        }
        val asyncBalancedRight = async(CommonPool) {
            balancedTreesCooroutines(nodes - 1 - n, element)
        }
        val balancedLeft = asyncBalancedLeft.await()
        val balancedRight = asyncBalancedRight.await()

        val mapped = HashSet<Pair<Tree<T>,Tree<T>>>()
        val mappedSequence = buildSequence {
            balancedLeft.forEach { left ->
                balancedRight.forEach { right ->
                    yieldAll(flatMapTree(mapped, left, right, element))
                }
            }
        }
        var toList = listOf<Tree<T>>()
        val time = measureTimeMillis {
            toList = mappedSequence.toList()
        }
        "balancedRight size: ${balancedRight.size}".print()
        "balancedLeft  size: ${balancedLeft.size}".print()
        "to list took $time".print()
        return toList
    }
}

private fun <T> flatMapTree(mapped: HashSet<Pair<Tree<T>, Tree<T>>>, left: Tree<T>, right: Tree<T>, element: T): List<Node<T>> {
    val didHaveLeftRight = mapped.add(Pair(left, right))
    val didHaveRightLeft=  mapped.add(Pair(right, left))
    val didNotHaveThisPair = didHaveLeftRight || didHaveRightLeft
    return if (didNotHaveThisPair) {
        if (left == right) {
            listOf(Node(element, left, right))
        } else {
            listOf(Node(element, left, right), Node(element, right, left))
        }
    } else {
        listOf()
    }
}