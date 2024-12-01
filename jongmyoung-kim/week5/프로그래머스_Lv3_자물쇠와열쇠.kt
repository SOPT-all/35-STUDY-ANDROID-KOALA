package week5

fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
    val expandedLock = Array(lock.size * 3) { IntArray(lock.size * 3) }
    var copiedKey = key

    for (i in lock.indices) {
        for (j in lock.indices) {
            expandedLock[i + lock.size][j + lock.size] = lock[i][j]
        }
    }

    repeat(4) {
        for (x in 0 until lock.size * 2) {
            for (y in 0 until lock.size * 2) {
                for (i in key.indices) {
                    for (j in key.indices) {
                        expandedLock[x + i][y + j] += copiedKey[i][j]
                    }
                }
                if (check(lock, expandedLock)) return true

                for (i in key.indices) {
                    for (j in key.indices) {
                        expandedLock[x + i][y + j] -= copiedKey[i][j]
                    }
                }
            }
        }
        copiedKey = rotate(copiedKey)
    }
    return false
}

fun check(lock: Array<IntArray>, expandedLock: Array<IntArray>): Boolean {
    for (i in lock.size until lock.size * 2) {
        for (j in lock.size until lock.size * 2) {
            if (expandedLock[i][j] != 1)
                return false
        }
    }
    return true
}

fun rotate(key: Array<IntArray>): Array<IntArray> {
    val rotatedKey = Array(key.size) { IntArray(key.size) }
    for (i in key.indices) {
        for (j in key.indices) {
            rotatedKey[i][j] = key[key.size - j - 1][i]
        }
    }
    return rotatedKey
}
