package p15904

object Solution {
    fun containsUCPC(sentence: String): Boolean {
        val target: String = "UCPC"
        var cursor: Int = 0

        for (c: Char in sentence) {
            if (c == target[cursor]) {
                cursor += 1
            }

            if (cursor == target.length) {
                return true
            }
        }

        return cursor == target.length
    }

    fun solve() {
        var sentence: String = readLine() ?: ""

        if (containsUCPC(sentence)) {
            println("I love UCPC")
        } else {
            println("I hate UCPC")
        }
    }
}

fun main() {
    Solution.solve()
}