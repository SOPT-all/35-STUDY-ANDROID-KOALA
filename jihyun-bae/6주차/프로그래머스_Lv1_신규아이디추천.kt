class Solution {
    fun solution(new_id: String): String = new_id.lowercase()
    .replace("[^a-z0-9_.-]".toRegex(), "")
    .replace("[.]{2,}".toRegex(), ".")
    .trim('.')
    .ifEmpty { "a" }
    .let {
        when {
            it.length >= 16 -> it.substring(0, 15).trim('.')
            it.length <= 2 -> it.padEnd(3, it.last())
            else -> it
        }
    }
}
