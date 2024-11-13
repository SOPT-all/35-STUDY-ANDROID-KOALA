fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val numbers = Array(n) { readLine()!!.toInt() }.sorted()
    
    var start = 0
    var end = 0
    var minDiff = Int.MAX_VALUE
    
    while (end < n) {
        val diff = numbers[end] - numbers[start]
        
        when {
            diff < m -> end++
            else -> {
                minDiff = minOf(minDiff, diff)
                start++
            }
        }
        
        if (start > end) {
            end = start
        }
    }
    
    println(minDiff)
}