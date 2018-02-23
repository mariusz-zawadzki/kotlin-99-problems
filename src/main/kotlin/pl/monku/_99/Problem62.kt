package pl.monku._99


fun <T> Tree<T>.valuesAtLevel(l: Int): List<T> = when {
    this == End -> listOf<T>()
    this is Node -> if(l == 0){
        listOf(this.value)
    } else {
        this.left.valuesAtLevel(l-1) + this.right.valuesAtLevel(l-1)
    }
    else -> {
        throw IllegalArgumentException("Expected Node or End")
    }
}
