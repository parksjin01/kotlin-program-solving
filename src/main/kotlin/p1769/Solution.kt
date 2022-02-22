package p1769

object Solution {
    fun solve() {
        val num: String = readLine() ?: ""

        if (num.length > 1) {
            checkNumber(num.toCharArray().map { it - '0' }.sum(), 1)
        } else {
            checkNumber(num.toInt(), 0)
        }
    }

    private fun checkNumber(num: Int, shortenCnt: Int) {
        if (num < 10) {
            println(shortenCnt)

            if ((num % 3L) == 0L) {
                println("YES")
            } else {
                println("NO")
            }

            return
        }

        checkNumber(shorten(num), shortenCnt + 1)
    }

    private fun shorten(num: Int): Int {
        if (num < 10) {
            return num
        } else {
            return shorten(num / 10) + num % 10
        }
    }
}

fun main() {
    Solution.solve()
}