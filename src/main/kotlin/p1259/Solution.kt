package p1259

object PelindromeChecker {
    fun check(number: Int): Boolean {
        val numberString: String = number.toString()
        val reversedNumberString: String = numberString.reversed()

        return numberString == reversedNumberString
    }
}

object Solution {
    fun solve() {
        while (true) {
            val number: Int = readLine()?.toInt() ?: 0

            if (number == 0) {
                break
            } else if (PelindromeChecker.check(number)) {
                println("yes")
            } else {
                println("no")
            }
        }
    }
}

fun main() {
    Solution.solve()
}