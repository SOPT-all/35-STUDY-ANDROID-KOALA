package week8

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (player, game) = br.readLine().split(" ")
    val playerName = mutableSetOf<String>()

    repeat(player.toInt()) {
        playerName.add(br.readLine())
    }

    val divider = when (game) {
        "Y" -> 1
        "F" -> 2
        else -> 3
    }

    write("${playerName.size / divider}")
    close()
}
// distinct() 함수를 쓰게되면 시간복잡도가 증가하여 처음부터 set에 담아야 함