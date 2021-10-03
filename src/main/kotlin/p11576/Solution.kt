package p11576

import kotlin.math.pow

object BaseConverter {
    fun toDec(sourceBase: Int, number: List<Int>): Int {
        val reversedNumber: List<Int> = number.reversed()
        var cur: Int = 0
        var num: Int = 0

        for (digit: Int in reversedNumber) {
            num += (digit * sourceBase.toDouble().pow(cur)).toInt()
            cur += 1
        }

        return num
    }

    fun fromDec(targetBase: Int, number: Int): List<Int> {
        val num: MutableList<Int> = mutableListOf()
        var tempNumber: Int = number

        while (tempNumber > 0) {
            num.add(tempNumber % targetBase)
            tempNumber = tempNumber / targetBase
        }

        return num.reversed()
    }
}

object Solution {
    fun solve() {
        val (srcBase: Int, destBase: Int) = readLine() ?. split(" ") ?. map { it.toInt() } ?: listOf(0, 0)
        val numberOfDigit: Int = readLine() ?. toInt() ?: 0
        val digits: List<Int> = readLine() ?. split(" ") ?. map { it.toInt() } ?: emptyList()

        println(BaseConverter.fromDec(destBase, BaseConverter.toDec(srcBase, digits)).joinToString(" "))
    }
}

fun main() {
    Solution.solve()
}