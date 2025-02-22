package week10

import java.util.LinkedList

private val br = System.`in`.bufferedReader()

// 완전탐색
/*
fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val A = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    for (i in A.indices) {
        val subList = A.slice(i until A.size)
        if (subList.maxOf { it } <= A[i]) write("-1 ")
        else write("${subList.filter { it > A[i] }.minOf { it }} ")
    }
    close()
}
*/

// 단조 스택
fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val A = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val stack = LinkedList<Int>()

    for (i in A.indices) {
        while (stack.isNotEmpty() && A[stack.peek()] < A[i]) {
            A[stack.pop()] = A[i]
        }
        stack.push(i)
    }

    while (stack.isNotEmpty()) {
        A[stack.pop()] = -1
    }

    A.forEach { write("$it ") }
    close()
}