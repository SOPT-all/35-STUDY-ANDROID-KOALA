package week1

import java.io.*
import java.util.*

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val numberOfPeople = br.readLine().toInt()
    var st = StringTokenizer(br.readLine())
    val start = st.nextToken().toInt()
    val end = st.nextToken().toInt()
    val numberOfEdges = br.readLine().toInt()
    val edges = Array(numberOfPeople+1){ArrayList<Int>()}
    val visited = BooleanArray(numberOfPeople+1)
    var answer = -1

    for(i in 0 until numberOfEdges){
        st = StringTokenizer(br.readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        edges[from].add(to)
        edges[to].add(from)
    }

    answer = dfs(start, end, 0, visited, edges)
    bw.write(answer.toString())
    bw.close()
}

fun dfs(
    start: Int,
    end: Int,
    depth: Int,
    visited: BooleanArray,
    edges: Array<ArrayList<Int>>
): Int{
    var answer = -1
    if(start == end){
        return depth
    }
    visited[start] = true
    for(next in edges[start]){
        if(visited[next])continue
        answer = dfs(next, end,depth+1,visited,edges)
        if(answer!=-1) return answer
    }
    return -1
}