package pl.monku._99

fun <T> Tree<T>.isSymmetric() = when {
    this is Node -> areMirror(this.left, this.right)
    else -> true
}


fun <T> areMirror(l: Tree<T>, r: Tree<T>): Boolean = when {
    End === l && End === r -> true
    l is Node<T> && r is Node<T> -> areMirror(l.left, r.right) && areMirror(l.right, r.left)
    else -> false
}
