class Solution {
    data class Node (val now: Triple<Int, Int, Int>, var left: Node? = null, var right: Node? = null)
    
    var answer = Array(2) { mutableListOf<Int>() }
    
    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        val nodes = nodeinfo.mapIndexed { index, node -> Triple(index + 1, node[0], node[1]) }
            .sortedWith(compareByDescending<Triple<Int, Int, Int>> { it.third }.thenBy { it.second })

        val tree = Node(now = nodes[0])
        
        for (i in 1 until nodes.size) {
            addTree(tree, nodes[i])
        }
        
        preOrder(tree)
        postOrder(tree)

        return answer.map { it.toIntArray() }.toTypedArray()
    }
    
    fun addTree(current: Node, newNode: Triple<Int, Int, Int>) {
        if (current.now.second > newNode.second) {
            if (current.left == null) current.left = Node(now = newNode)
            else current.left?.let { addTree(it, newNode) }
        } else {
            if (current.right == null) current.right = Node(now = newNode)
            else current.right?.let { addTree(it, newNode) }
        }
    }
    
    fun preOrder(tree: Node) {
        answer[0] += tree.now.first
        tree.left?.let { preOrder(it) }
        tree.right?.let { preOrder(it) }
    }
    
    fun postOrder(tree: Node) {
        tree.left?.let { postOrder(it) }
        tree.right?.let { postOrder(it) }
        answer[1] += tree.now.first
    }
}
