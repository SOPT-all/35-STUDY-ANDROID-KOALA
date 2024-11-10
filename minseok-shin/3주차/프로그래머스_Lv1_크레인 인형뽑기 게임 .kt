package com.example.andsoptkoala

import java.util.Stack

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val pocket = Stack<Int>()
        val transposedBoard = Array(board[0].size) { IntArray(board.size) }
        for (i in board.indices) {
            for (j in board[i].indices) {
                transposedBoard[j][i] = board[i][j]
            }
        }
        for (pick in moves){
            var top = 0
            for (i in transposedBoard[pick-1].indices){
                if (transposedBoard[pick-1][i]!=0) {
                    top = transposedBoard[pick-1][i]
                    transposedBoard[pick-1][i]=0
                    break
                }
            }
            if (pocket.isNotEmpty() && pocket.peek()==top){
                pocket.pop()
                answer+=2
            }
            else{
                if (top!=0){
                    pocket.add(top)
                }
            }
        }
        return answer
    }
}
