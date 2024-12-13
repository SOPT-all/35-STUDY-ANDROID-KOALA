class Solution {
    fun solution(new_id: String) = new_id
        .lowercase()
        .filter { it.isLetterOrDigit() || it in "-_." }
        .replace("\\.+".toRegex(), ".")
        .trimStart('.')
        .trimEnd('.')
        .ifEmpty { "a" }
        .take(15)
        .trimEnd('.')
        .let { it + it.last().toString().repeat(maxOf(0, 3 - it.length)) }
}