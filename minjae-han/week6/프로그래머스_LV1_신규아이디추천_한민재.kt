class Solution {
    fun solution(new_id: String): String {
        return new_id
            .lowercase()
            .replace("[^a-z0-9-_.]".toRegex(), "")
            .replace("\\.+".toRegex(), ".")
            .trim('.')
            .ifEmpty { "a" }
            .let { if (it.length >= 16) it.substring(0, 15).trimEnd('.') else it }
            .let {
                if (it.length <= 2) 
                    it + it.last().toString().repeat(3 - it.length)
                else it
            }
    }
}