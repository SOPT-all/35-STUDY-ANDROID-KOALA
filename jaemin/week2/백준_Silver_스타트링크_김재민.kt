package week2

import java.io.*
import java.util.*

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val numberOfFloors = st.nextToken().toInt()
    var currentFloor = st.nextToken().toInt()
    val floorOfStartlink = st.nextToken().toInt()
    val upFloors = st.nextToken().toInt()
    val downFloors = st.nextToken().toInt()

    val graph = Array(numberOfFloors+1){index ->
        intArrayOf(index-downFloors, index+upFloors)
    }

    val queue = LinkedList<Int>()
    val visited = BooleanArray(numberOfFloors+1)
    val count = IntArray(numberOfFloors+1)  // 각층별 도달까지 걸리는 횟수
    var isElevatorAvailable = false

    queue.add(currentFloor)
    visited[currentFloor] = true
    if(currentFloor == floorOfStartlink) isElevatorAvailable = true

    while(queue.isNotEmpty() && !isElevatorAvailable){
        currentFloor = queue.poll()
        for(nextFloor in graph[currentFloor]){
            if(nextFloor in 1 .. numberOfFloors && !visited[nextFloor]){
                visited[nextFloor] = true
                count[nextFloor] = count[currentFloor] + 1
                if(nextFloor == floorOfStartlink) isElevatorAvailable = true
                queue.add(nextFloor)
            }
        }
    }
//
//    print(graph.contentDeepToString())
//    print(visited.contentToString())

    if(isElevatorAvailable) print(count[floorOfStartlink])
    else{
        print("use the stairs")
    }
}