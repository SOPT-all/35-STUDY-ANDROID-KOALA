package week8

class Node(val coordinate: Triple<Int, Int, Int>) {
    var left: Node? = null
    var right: Node? = null
}

class BinaryTree(val root: Node) {
    fun addNode(coordinate: Triple<Int, Int, Int>) = find(root, coordinate)

    fun find(parent: Node, coordinate: Triple<Int, Int, Int>) {
        if (coordinate.second < parent.coordinate.second) {
            if (parent.left == null) parent.left = Node(coordinate)
            else find(parent.left!!, coordinate)
        } else {
            if (parent.right == null) parent.right = Node(coordinate)
            else find(parent.right!!, coordinate)
        }
    }

    var preArr = intArrayOf()
    var postArr = intArrayOf()

    fun preorder(node: Node) {
        preArr += node.coordinate.first
        node.left?.let { preorder(it) }
        node.right?.let { preorder(it) }
    }

    fun postorder(node: Node) {
        node.left?.let { postorder(it) }
        node.right?.let { postorder(it) }
        postArr += node.coordinate.first
    }
}

fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
    val sortedNode = nodeinfo.mapIndexed { index, node -> Triple(index + 1, node[0], node[1]) }
        .sortedWith(compareByDescending<Triple<Int, Int, Int>> { it.third }.thenBy { it.second })
    val binaryTree = BinaryTree(Node(sortedNode[0]))

    for (i in sortedNode.indices) binaryTree.addNode(sortedNode[i + 1])

    binaryTree.preorder(binaryTree.root)
    binaryTree.postorder(binaryTree.root)

    return arrayOf(binaryTree.preArr, binaryTree.postArr)
}