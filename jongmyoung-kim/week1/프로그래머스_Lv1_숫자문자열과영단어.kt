package week1

fun engToNum(s: String): Int {
    var result = s
    enumValues<Numbers>().forEach {
        result = result.replace(it.engNum, it.num)
    }
    return result.toInt()
}
enum class Numbers(
    val engNum: String,
    val num: String
) {
    ZERO("zero", "0"),
    ONE("one", "1"),
    TWO("two", "2"),
    THREE("three", "3"),
    FOUR("four", "4"),
    FIVE("five", "5"),
    SIX("six", "6"),
    SEVEN("seven", "7"),
    EIGHT("eight", "8"),
    NINE("nine", "9")
}