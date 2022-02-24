package p16171

object Solution {
    fun solve() {
        val sentence: String = readLine() ?. toCharArray() ?. filter { it.isLetter() } ?. joinToString("") ?: ""
        val keyword: String = readLine() ?: ""

        if (keyword in sentence) {
            println(1)
        } else {
            println(0)
        }
    }
}

fun main() {
    Solution.solve()
}