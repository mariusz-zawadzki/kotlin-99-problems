package pl.monku._99


fun <T> symmetricBalancedTrees(n: Int, element: T): List<Tree<T>> = balancedTrees(n,element).filter { it.isSymmetric() }