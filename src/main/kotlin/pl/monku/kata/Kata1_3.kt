package pl.monku.kata

/**
 * Created by mariusz.r.zawadzki@gmail.com on 09.08.17.
 */

fun chopRecursionIterative(needle: Int, hayStack: List<Int>): Int {

    var searchStack = hayStack
    var offset = 0
    while (searchStack.isNotEmpty()) {
        val index = searchStack.size / 2
        val mid = searchStack[index]
        if (mid == needle) {
            return offset + index
        } else if (searchStack.size == 1) {
            return -1
        }
        val lowerBound = if (needle < mid) 0 else index
        val upperBound = if (needle < mid) index else searchStack.size
        searchStack = hayStack.subList(lowerBound + offset, upperBound + offset)
        offset += lowerBound
    }
    return -1
}