val visited = BooleanArray(101) { false }
var relationCount = -1

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val totalPeople = br.readLine().toInt()
    val (relative1, relative2) = br.readLine().split(" ").map { it.toInt() }
    val totalRelation = br.readLine().toInt()
    val relationArr = Array(totalPeople + 1) { IntArray(totalPeople + 1) }

    repeat(totalRelation) {
        val (parent, child) = br.readLine().split(" ").map { it.toInt() }
        relationArr[parent][child] = 1
        relationArr[child][parent] = 1
    }

    dfs(relative1, relative2, relationArr, 0)

    bw.write(relationCount.toString())
    bw.flush()
    bw.close()
}
fun dfs(relative1: Int, relative2: Int, relationArr: Array<IntArray>, count: Int) {
    visited[relative1] = true

    if(relative1 == relative2) {
        relationCount = count
        return
    }
    for (i in relationArr.indices) {
        if (relationArr[relative1][i] == 1 && !visited[i]) {
            dfs(i, relative2, relationArr, count + 1)
            if (relationCount != -1) return
        }
    }
}
