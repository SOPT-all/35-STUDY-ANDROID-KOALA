package week1

import java.io.*
import java.util.*

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val direction = arrayOf(Pair(-1,0), Pair(0,1), Pair(1,0), Pair(0,-1))
    var answer = 0

    var st = StringTokenizer(br.readLine())
    val row = st.nextToken().toInt()
    val column = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    var currentRow = st.nextToken().toInt()
    var currentColumn = st.nextToken().toInt()
    var currentDirection = st.nextToken().toInt()

    var nextRow: Int
    var nextColumn: Int

    val room = Array(row){
        st = StringTokenizer(br.readLine())
        Array(column){st.nextToken().toInt()}
    }

    while(true){
        var isNeighborDirty = false

        if(room[currentRow][currentColumn] == 0){
            answer +=1
            room[currentRow][currentColumn] = 2
        }else if(room[currentRow][currentColumn]==1) break

        for(i in 0 until 4){
            if(room[currentRow+direction[i].first][currentColumn+direction[i].second] == 0){
                isNeighborDirty = true
                break
            }
        }

        if(isNeighborDirty){
            do {
                currentDirection = (currentDirection+3)%4
                nextRow = currentRow+direction[currentDirection].first
                nextColumn = currentColumn+direction[currentDirection].second
            }while(room[nextRow][nextColumn] != 0)
            currentRow = nextRow
            currentColumn = nextColumn
        }else{  // 후진
            currentRow += direction[(currentDirection+2)%4].first
            currentColumn += direction[(currentDirection+2)%4].second
        }
    }

    bw.write(answer.toString())
    bw.close()
}