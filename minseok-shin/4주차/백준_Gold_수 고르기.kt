package week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = mutableListOf<Int>()

    repeat(n) {
        arr.add(br.readLine().toInt())
    }

    arr.sort()

    var min = Int.MAX_VALUE
    var i = 0
    var j = 1

    while (i < n && j < n) {
        val diff = arr[j] - arr[i]

        if (diff >= m) {
            min = minOf(min, diff)
            i++
            if (i == j) j++
        } else {
            j++
        }
    }

    bw.write(min.toString())
    bw.flush()
    bw.close()
    br.close()
}
