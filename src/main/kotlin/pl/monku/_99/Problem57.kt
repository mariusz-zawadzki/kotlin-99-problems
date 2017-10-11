package pl.monku._99

fun <T : Comparable<T>> Tree<T>.add(element: T): Tree<T> {
    return if (this is Node<T>) {
        if (this.value > element) {
            Node(value, left.add(element), right)
        } else {
            Node(value, left, right.add(element))
        }
    } else {
        Node(element)
    }
}


fun <T: Comparable<T>> List<T>.toTree(): Tree<T>{
    var tree: Tree<T> =  End
    for (t in this) {
        tree = tree.add(t)
    }
    return tree
}