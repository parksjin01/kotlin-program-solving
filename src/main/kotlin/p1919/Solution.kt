package p1919

import java.lang.Exception

object Solution {
    fun solve() {
        val word1: String = readLine() ?: ""
        val word2: String = readLine() ?: ""
        val word1Chars: MutableMap<Char, Int> = word1.groupBy { it }.mapValues { it.value.size }.toMutableMap()
        var count: Int = 0

        for (char in word2) {
            try {
                if (word1Chars[char]!! > 0)
                    word1Chars[char] = word1Chars[char]?.minus(1) ?: 0
                else
                    count += 1
            } catch (e: Exception) {
                count += 1
            }
        }

        count += word1Chars.values.sum()

        println(count)
    }
}

fun main() {
    Solution.solve()
}