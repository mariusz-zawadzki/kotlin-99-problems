package pl.monku.kata

/**
 * Created by mariusz.r.zawadzki@gmail.com on 09.08.17.
 */
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
