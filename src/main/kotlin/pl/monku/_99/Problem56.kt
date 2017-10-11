package pl.monku._99

fun <T> Tree<T>.isSymmetric(): Boolean{
    if(this is Node){
        return areMirror(this.left, this.right)
    }
    return true
}

fun <T> areMirror(l: Tree<T>, r: Tree<T>): Boolean{
    if(End.equals(l) && End.equals(r)){
        return true
    }
    else if(l is Node<T> && r is Node<T>){
        return areMirror(l.left, r.right) && areMirror(l.right, r.left)
    }
    else
        return false
}
