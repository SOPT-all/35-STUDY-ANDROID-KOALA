package week6

fun solution(new_id: String): String {
    return new_id.lowercase().filter {
        it.isLowerCase() || it.isDigit() || it == '-' || it == '_' || it == '.'
    }.replace("[.]*[.]".toRegex(), ".").trim('.').ifEmpty { "a" }
        .let {
            if (it.length >= 16) it.substring(0, 15).trim('.')
            else if (it.length <= 2) it.padEnd(3, it.last())
            else it
        }
}