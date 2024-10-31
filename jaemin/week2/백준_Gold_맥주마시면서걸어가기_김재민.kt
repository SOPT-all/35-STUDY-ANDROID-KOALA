package week2

import java.io.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    repeat(br.readLine().toInt()){
        val numberOfConvenienceStore = br.readLine().toInt()

        val coordinates = Array(numberOfConvenienceStore+2){
            val st = StringTokenizer(br.readLine())
            Pair(st.nextToken().toInt(),st.nextToken().toInt())
        }

        val graph = Array(numberOfConvenienceStore + 2){
            ArrayList<Int>()
        }

        for(i in 0..numberOfConvenienceStore){
            for(j in i+1 .. numberOfConvenienceStore+1){
                if(abs(coordinates[i].first - coordinates[j].first)
                    + abs(coordinates[i].second - coordinates[j].second)<=1000){
                    graph[i].add(j)
                    graph[j].add(i)
                }
            }
        }

        val destination = numberOfConvenienceStore + 1
        val queue = LinkedList<Int>()
        val visited = BooleanArray(numberOfConvenienceStore+2)

        visited[0] = true
        queue.add(0)

        while(queue.isNotEmpty() && !visited[destination]){
            val currentLocation = queue.poll()

            for(nextLocation in graph[currentLocation]){
                if(!visited[nextLocation]){
                    visited[nextLocation] = true
                    queue.add(nextLocation)
                }
            }
        }

        if(visited[destination])println("happy") else println("sad")
//
//        print(coordinates.contentDeepToString())
//        print(graph.contentDeepToString())
//        print(visited.contentToString())
    }
}