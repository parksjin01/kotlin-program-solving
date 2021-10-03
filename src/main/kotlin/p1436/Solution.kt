package p1436

object Solution {
    fun has666(number: Int): Boolean {
        return number.toString().contains("666")
    }

    fun solve() {
        val targetIdx: Int = readLine() ?. toInt() ?: 1

        var cnt: Int = 0
        var startNumber: Int = 666

        while (cnt < targetIdx) {
            if (has666(startNumber)) {
                cnt += 1
            }

            if (cnt < targetIdx) {
                startNumber += 1
            }
        }

        println(startNumber)
    }
}

fun main() {
    Solution.solve()
}