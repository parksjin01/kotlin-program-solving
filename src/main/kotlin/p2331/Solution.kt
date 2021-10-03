package p2331

import kotlin.math.pow

object Solution {
    fun next(number: Long, factor: Int): Long {
        var num: Long = 0
        var tempNumber: Long = number

        while (tempNumber > 0) {
            num += (tempNumber % 10).toDouble().pow(factor).toLong()
            tempNumber = tempNumber / 10
        }

        return num
    }

    fun solve() {
        val (a: Int, p: Int) = readLine() ?. split(" ") ?. map { it.toInt() } ?: listOf(0, 0)
        val numbers: MutableList<Long> = mutableListOf(a.toLong())

        while (true) {
            val nextNumber: Long = next(numbers.last(), p)

            if (numbers.contains(nextNumber)) {
                val idx: Int = numbers.indexOf(nextNumber)
                println(idx)
                break
            }

            numbers.add(nextNumber)
        }
    }
}

fun main() {
    Solution.solve()
}