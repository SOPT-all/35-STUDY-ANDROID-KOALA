import java.io.*
import java.util.*

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val direction = arrayOf(Pair(1,0),Pair(0,1),Pair(-1,0),Pair(0,-1))
    val size = br.readLine().toInt()
    val map = Array(size){IntArray(size)}
    var answer = 1
    var minHeight = 101
    var maxHeight = 0

    for(i in 0 until size){
        val st = StringTokenizer(br.readLine())
        for(j in 0 until size){
            map[i][j] = st.nextToken().toInt()
            minHeight = if(map[i][j] < minHeight) map[i][j] else minHeight
            maxHeight = if(map[i][j] > maxHeight) map[i][j] else maxHeight
        }
    }

    repeat(maxHeight-minHeight){
        val visited = Array(size){ BooleanArray(size) }
        val queue = LinkedList<Pair<Int,Int>>()
        var count = 0
        for(i in 0 until size){
            for(j in 0 until size){
                if(!visited[i][j] && minHeight < map[i][j]){
                    queue.add(Pair(i,j))
                    visited[i][j] = true
                    map[i][j]--

                    while(queue.isNotEmpty()){
                        val currentLocation = queue.poll()
                        val currentX = currentLocation.first
                        val currentY = currentLocation.second

                        for(k in 0 until 4){
                            val nextX = currentX + direction[k].first
                            val nextY = currentY + direction[k].second
                            if(nextX in 0 until size
                                && nextY in 0 until size
                                && minHeight < map[nextX][nextY]
                                &&!visited[nextX][nextY]){
                                queue.add(Pair(nextX,nextY))
                                visited[nextX][nextY] = true
                                map[nextX][nextY]--
                            }
                        }
                    }
                    count++
                }
            }
        }
        answer = if(answer>count) answer else count
    }
    println(answer)
}