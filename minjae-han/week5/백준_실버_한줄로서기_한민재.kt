fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val info = readLine().split(" ").map { it.toInt() }
    val result = MutableList(n) { 0 }
    
    for(h in 1..n) {
        var empty = info[h-1] 
        for(i in 0 until n) {
            if(empty == 0 && result[i] == 0) {  
                result[i] = h
                break
            }
            if(result[i] == 0) empty-- 
        }
    }
    
    println(result.joinToString(" "))
}