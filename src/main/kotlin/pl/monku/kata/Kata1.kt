package pl.monku.kata

//approach 1
fun chop(needle: Int, hayStack: List<Int>): Int {
    var index = hayStack.size / 2
    var upperBound = hayStack.lastIndex
    var lowerBound = 0
    while (index > -1 && index < hayStack.size) {
        val mid = hayStack[index]
        if (mid == needle) {
            return index
        }
        if (needle < mid) {
            val halfIndex = (lowerBound + index) / 2
            index = if (halfIndex == index) -1 else halfIndex
            upperBound = index
        } else {
            val halfIndex = (upperBound + index) / 2
            index = if (halfIndex == index) halfIndex + 1 else halfIndex
            lowerBound = index
        }
    }

    return -1
}

//approach 2
fun chopRecursion(needle: Int, hayStack: List<Int>): Int = chopRecursionInner(needle, hayStack, 0)

fun chopRecursionInner(needle: Int, hayStack: List<Int>, offset: Int): Int {

    if (hayStack.isEmpty()) {
        return -1
    }
    val index = hayStack.size / 2
    var upperBound = hayStack.size
    var lowerBound = 0
    val mid = hayStack[index]
    if (mid == needle) {
        return offset + index
    }
    if (needle < mid) {
        upperBound = index
    } else {
        lowerBound = index
    }
    if (lowerBound == 0 && upperBound == hayStack.size) {
        return -1
    }
    val chopRecursion = chopRecursionInner(needle, hayStack.subList(lowerBound, upperBound), lowerBound)
    return if (chopRecursion < 0) -1 else offset + chopRecursion
}

//approach 3
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